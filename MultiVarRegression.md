####Linear Regression with multiple variables

for problems with more than one input variables, we have modify the model to be:
```
y = A + Bx1 + Cx2 + Dx3 + ...
```
Then we have a coefficient matrix __C__.

To estimate the coeffiecients, we can use either *Gradient descent* or solve it directly by *Normal equation*.

1. Gradient descent
  * we can use this method to find good coeffcient values by minimize Mean Squared Error(MSE) function.
  ```
  Initialize theta(starting position)
  Do{
  theta = theta - a*X     (a is the step size;X is the Gradient vector indicating steepest Gradient direction)
  }while(no converge)
  ```
  * the performance of the method depends on:
    * starting point: since it converges at local minimum, different starting point may lead to different minimum 
    * step of each iteration:if choose too large step, it may go back and forth around the minimun;if choose too small step, it will go very little step in every iteration. Both of them will lead to long time before convergence.
    * stopping condition
    * when dataset is large we can use stochastic gradient descent, which updates by randomly pick a group of point in each iteration
2. Normal equation

compare to gradient descent, dicrectly solving the equation have following properties:
  * no need to choose step and no need to iterate
  * slow if dataset is large


  
