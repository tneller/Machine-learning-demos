'''
@author: yangzuozhi
'''

import pylab as pl
import numpy as np

#k,b = float(raw_input()),float(raw_input()) use this to input a line
k,b = 0.5,10 # default line
def computeY(x,k,b):
    return k*x+b

pl.figure(figsize=(17, 8))
pl.subplots_adjust(left=.001, right=.999, bottom=.001, top=.999, wspace=.001,hspace=.1)

for index in range(1,11):
    r = np.arange(0,51,1)
    sample = []
    for x in r:
        s = np.random.normal(loc = computeY(x,k,b),scale = index) # randomly generate data
        sample.append(s)
    
    pl.subplot(2,5,index) # 10 subplots
    pl.plot(r,sample,'ro') # plot original line

    x_avg = np.average(r)
    y_avg = np.average(sample)
    sum1 = 0
    sum2 = 0
    # compute parameters of regression line
    for i in range(0,51):
        sum1 += (r[i]-x_avg)*(sample[i]-y_avg)
        sum2 += (r[i]-x_avg)**2  
    beta1 = sum1/sum2  
    beta0 = y_avg - x_avg*beta1

    pl.axis([0,50,0,50])
    pl.plot(r,computeY(r,k,b))
    pl.plot(r,computeY(r,beta1,beta0),"r-") # plot predicting line

pl.show()
