import pylab as pl
import numpy as np



origin = [50,0,-0.7]

def computeY(x,beta):
    y = 0.0
    for i in range(0,len(beta)):
        y += beta[i]*np.power(x,i)
    return y



degree = 1
numOfData = 10

pl.figure(figsize=(16, 8))
pl.subplots_adjust(left=.001, right=.999, bottom=.001, top=.999, wspace=.001,hspace=.1)

sample = []
r = np.arange(1,numOfData+1,1)
for x in r:
    s = np.random.normal(loc = computeY(x,origin),scale = 1.75)
    sample.append(s)
for index in range(1,7):
    
    
    
    pl.subplot(2,3,index)
    pl.plot(r,sample,'ro')
    
    X = []
    for x in range(1,numOfData+1):
        row = []
        for i in range(0,degree+1):
            row.append(np.power(x,i))
        X.append(row)
    X = np.mat(X)
    
    I = np.identity(index+1)
    I[0][0] = 0
    Beta = np.linalg.inv(X.transpose().dot(X)+I).dot(X.transpose()).dot(sample)
    Beta = np.squeeze(np.asarray(Beta))
    print Beta
 
    pl.axis([0,numOfData+1,0,50])
    pl.plot(r,computeY(r,origin),"b-")
    pl.plot(r,computeY(r,Beta),"r-")
    degree += 1

pl.show()