import numpy as np

def logistic(x):
    return 1.0/(1.0 + np.exp(-x))

def logistic_derivative(y):
    return y*(1-y)


class NeuralNetwork:

    def __init__(self, layers):
        self.weights = []
        #hidden layer weights
        for i in range(1, len(layers) - 1):
            r = 2*np.random.random((layers[i-1] + 1, layers[i] + 1)) - 1
            self.weights.append(r)
        #output layer weights
        r = 2*np.random.random( (layers[-2] + 1, layers[-1])) - 1
        self.weights.append(r)
    def train(self, X, y, learning_rate=0., iteration=50000):
        ones = np.atleast_2d(np.ones(X.shape[0]))
        
        X = np.concatenate((ones.T, X), axis=1)
         
        for k in range(iteration):
            i = np.random.randint(X.shape[0])
            trainer = [X[i]]
            for l in range(len(self.weights)):
                    dot_product = np.dot(trainer[l], self.weights[l])
                    trainer.append(logistic(dot_product))
            # output layer error and gradient
            error = y[i] - trainer[-1]
            gradients = [error * logistic_derivative(trainer[-1])]
            # calculate
            for l in range(len(trainer) - 2, 0, -1): 
                gradients.append(gradients[-1].dot(self.weights[l].T)*logistic_derivative(trainer[l]))
            gradients.reverse()

            # backpropagation
            for i in range(len(self.weights)):
                layer = np.atleast_2d(trainer[i])
                delta = np.atleast_2d(gradients[i])
                self.weights[i] += learning_rate * layer.T.dot(delta)


    def predict(self, x): 
        a = np.concatenate((np.ones(1).T, np.array(x)), axis=1)      
        for l in range(0, len(self.weights)):
            a = logistic(np.dot(a, self.weights[l]))
        return a



nn = NeuralNetwork([2,2,1])
XOR = np.array([[0, 0],[0, 1],[1, 0],[1, 1]])
y = np.array([0, 1, 1, 0])
nn.train(XOR, y)
for gate in XOR:
    print(gate,round(nn.predict(gate)[0],3))