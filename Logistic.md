####Logistic Regression

We use Logistic regression for predicting values between zero and one(probabilities). Thus it is commonly used as a binary classification method, where the two class values are taken to be zero or one.
The logistic function has a "sigmoid" shape; it looks like a flattened-out "S". 

Its functional form is:

<img src="http://www.forkosh.com/mathtex.cgi? \beta(x) = \frac{1}{1+e^{-x}}">

And its derivative is :

<img src="http://www.forkosh.com/mathtex.cgi? \beta'(x) =  \beta(x) \cdot ( 1-\beta(x) ) ">

We can define the reverse of the logistic fundtion ,_g(x)_, logit.:

<img src="http://www.forkosh.com/mathtex.cgi? g(\beta(x)) = log\left( \frac{\beta(x)}{1-\beta(x)} \right) = \lambda_0 + \lambda_1x">

When we have more than 2 classes, 

Properties:
  1. Computationally inexpensive
  2. easy to implement and interpret
  3. prone to underfit
  4. logistic function is smooth, so we can use gradient descent/ascent
