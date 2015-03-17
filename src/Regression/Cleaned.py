import numpy as np


raw_data = np.recfromcsv("data/red.csv",delimiter=';')


X = []
Y = []
for line in raw_data:
    row = []
    for i in range(0,len(line)-1):
        if(i!=0 and i!=2 and i!=6 and i!=7):
            row.append(line[i])
    Y.append(line[len(line)-1])
    X.append(row)
X = np.mat(X)
Y = np.transpose(np.mat(Y))

sample = X[:1000]
test = X[1000:]

sY = Y[:1000]
tY = Y[1000:]


Beta = np.linalg.inv(sample.transpose().dot(sample)).dot(sample.transpose()).dot(sY)
Beta = np.squeeze(Beta)
 
error = []
for index in range(len(test)):
    x = Beta[0].dot(np.transpose(test[index]))
 
    error.append(tY[index][0] - x)
print np.std(error)