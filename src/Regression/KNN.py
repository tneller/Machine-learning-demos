import numpy as np


raw_data = np.recfromcsv("data/red.csv",delimiter=';')


X = []
Y = []
for line in raw_data:
    row = []
    for i in range(0,len(line)-1):
        row.append(line[i])
    Y.append(line[len(line)-1])
    X.append(row)
X = np.mat(X)

Y = np.transpose(np.mat(Y))

sample = X[:1500]
test = X[1500:]

sY = Y[:1500]
tY = Y[1500:]

p = []
for j in range(0,len(tY)-1):
    y = test[j]
    dist = []
    for i in range(len(sample)):
        x = np.linalg.norm(sample[i]-y)
        dist.append([x,i])
        dist.sort()
    n1 = float(sY[dist[0][1]])
    n2 = float(sY[dist[1][1]])
    n3 = float(sY[dist[2][1]])
    n4 = float(sY[dist[3][1]])
    n5 = float(sY[dist[4][1]])
    q = ((n1+n2+n3+n4+n5)/5)
    p.append(q-tY[j])
print np.std(p)