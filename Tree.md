####Tree based classifiers

#####Decision Trees

The decision tree usually consist of "comparison nodes". At each node a feature is evaluated. At some point, this process reaches a "decision node", at which one of the possible class categories is output. Thus, One advantage of decision trees is that they produce very interpretable decision rules; they are easy to evaluate "by hand", so that the factors that went into the class decision can be easily stated.

**Entropy**
We will decide which feature to use by the notion of imformation entropy. This concept describes the amount of impurity in a set of features.

<img src="http://www.forkosh.com/mathtex.cgi? Entropy(p) = -\sum_i p_i log_2p_i">

For decision tree, the best feature to pick is the one that gives yo the most imformation, i.e., the one with the highest entropy.

After using that feature, we re-evaluate the entropy of each feature and pick the one with highest entropy again.

#####Ensemble learning

The basic idea is that by having lots of learners that each get slightly different results on a dataset. 

1. Boosting

  Boosting is take a collection of weak and simple learnes and put them together to make an ensemble learner.
  * Adaptive boosting(Adaboost)
  
    In adaboost we give each learner weights and iteratively update those weights.   

2. Bootstrap aggregating(Bagging) 
  
  A boostrao sample is a sample taken from the original datasets with replacement. So we will get a slightly different datasets.
 
  
