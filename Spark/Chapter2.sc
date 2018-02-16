// data in Downloads/sparkBook/chapter2
// Run the scpark shell in this directory

import org.apache.spark.SparkContext

val rawblocks = sc.textFile("block_*.csv")
rawblocks.first
val head = rawblocks.take(10)
head.foreach(println)
//separate the header
def isHeader(line:String) = line.contains("id_1")
isHeader(rawblocks.first)
// filter method
head.filter(isHeader).foreach(println)
head.filterNot(isHeader).length
head.filter( x => !isHeader(x)).length
head.filter(!isHeader(_)).length
val noheader = rawblocks.filter( x => !isHeader(x))
noheader.first

// From RDD to Dataframe
// creating a data frame using csv method

val prev = spark.read.csv("block_*.csv")
prev.show()
// with some options
val parsed = spark.read.
  option("header","true").
  option("nullValues", "?").
  option("inferSchema","true").csv("block_*.csv")
parsed.show()
parsed.printSchema()

//Analysing with DataFrame API
//reading into memory:parsing
parsed.cache()
// count by value of matched
parsed.rdd.
  map(_.getAs[Boolean]("is_match")).
  countByValue()

// more prefered way of aggregation

parsed.
  groupBy("is_match").
  count().
  orderBy($"count".desc).
  show()

parsed.agg(avg($"cmp_sex"),stddev($"cmp_sex")).show()

// summary
parsed.describe().show()
val summary = parsed.describe()
summary.select("summary","cmp_sex").show()

val matches = parsed.where("is_match = true")
val matchSummary = matches.describe()

val misses = parsed.filter($"is_match"===false)
val missSummary = misses.describe()

matchSummary.show()
missSummary.show()

// pivoting and reshaping

summary.printSchema()
val schema = summary.schema
val longForm = summary.flatMap( row => {
  val metric = row.getString(0)
  (1 until row.size).map( i => {
    (metric, schema(i).name, row.getString(i).toDouble)
  })
})
longForm.show
val longDF = longForm.toDF("metric", "field", "value")
longDF.show()

val wideDF = longDF.
  groupBy("field").
  pivot("metric", Seq("count", "mean", "stddev", "min", "max")).
  agg(first("value"))
wideDF.select("field", "count", "mean").show()
// the above code did not worked because max has missing values below I excluded max
val summary1 = summary.filter( row => row.getString(0)!= "max")
val schema1 = summary1.schema
val longForm1 = summary1.flatMap( row => {
  val metric = row.getString(0)
  (1 until row.size).map( i => {
    (metric, schema(i).name, row.getString(i).toDouble)
  })
})

longForm1.show
val longDF1 = longForm1.toDF("metric", "field", "value")
longDF1.show()

val wideDF1 = longDF1.
  groupBy("field").
  pivot("metric", Seq("count", "mean", "stddev", "min")).
  agg(first("value"))
wideDF1.select("field", "count", "mean").show()


// Joining data frames and selecting features
