####Naive Bayes Classifier and kNN Classifier

#####Bayes Classifier
The full Bayes classifier is based on the Bayes Rule: __P(y|x) = P(x|y)P(y)/P(x)__. 
We calculate the probablility for each class using the conditional distribution and classify it to the most possible class. 

#####Naive Bayes Classifier
However, full Bayes classifier is fraught with estimation related problems when the number of dimension is large. (n^d parameters) Thus, the naive bayes classifer makes a assumption that all features are independent. (number of parameters reduced to n) This assumption makes the classifier much easier. It immediately implies that the likelihood can be computed by the product of dimension-wise probabilities:
__P(x|c) = P(x|c1)P(x|c2)P(x|c3) ... P(x|cd)__

We can use Gaussian models to make "Bayes optimal" decision. The decision boundary is where the probabilities are equal.

Properties:
  1. cannot capture correlations in features
  2. cannot capture dependencies in features
  3. work with small amount of data
  4. handle multiple classes
  5. work with nominal values
  
#####k-Nearest Neighbors Classifier

This method traverse the whole training set to find k-nearest neighbors to the __x__ and pick the label with highest "vote".

Properties:
  1. training time is trivial: just look at the data.
  2. classfication time gets huge when training set gets huge.
  3. when there is a "tie" we can bring in more neighbor, or we can use a kernal trick to the distance.
  4. handle multiple classes.
  5. easily overfitting when k is small.
  6. can also be applied to regression problems.
  
// picture 

// code
