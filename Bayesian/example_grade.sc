// example: interdependence between difficulty, intelligence, grade, sat, letter

package dk.bayes.clustergraph.infer

import org.junit._
import org.junit.Assert._
import dk.bayes.clustergraph.GenericClusterGraph
import dk.bayes.clustergraph.testutil.AssertUtil._
import dk.bayes.clustergraph.factor.Var
import dk.bayes.clustergraph.factor.Factor
import dk.bayes.clustergraph.infer.LoopyBP

val difficultyVar = dk.bayes.clustergraph.factor.Var(1, 2)



