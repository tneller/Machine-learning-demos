####Naive Bayes Classifier and kNN Classifier

#####Bayes Classifier
The full Bayes classifier is based on the Bayes Rule: __P(y|x) = P(x|y)P(y)/P(x)__. 
We calculate the probablility for each class using the conditional distribution and classify it to the most possible class. 

#####Naive Bayes Classifier
However, full Bayes classifier is fraught with estimation related problems when the number of dimension is large. Thus, the naive bayes classifer makes a assumption that all features are independent. This assumption makes the classifier much easier. It immediately implies that the likelihood can be computed by the product of dimension-wise probabilities:
__P(x|c) = P(x|c1)P(x|c2)P(x|c3) ... P(x|cd)__
Properties:
  1. cannot capture correlations in features
  2. cannot capture dependencies in features
  3. work with small amount of data
  4. handle multiple classes
  5. work with nominal values
  
