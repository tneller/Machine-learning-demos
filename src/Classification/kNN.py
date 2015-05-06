import pylab as plt
import numpy as np
import random
raw_data = np.recfromcsv("../data/data3.csv")

m = {}
for line in raw_data:
    line[2] = int(line[2][len(line[2])-1])-1
    if not m.has_key(line[2]):
        m[line[2]] = []
    m[line[2]].append([line[0],line[1],line[2]])



fig = plt.figure()
 
ax = fig.add_subplot(111)
 
ax.set_xlim(0,1)
ax.set_ylim(0,1)
colors = "brcmgykw"

for key in m:
    for value in (m.get(key)):
        color = value[2]
        i = int(color[len(color)-1])
        ax.plot(value[0],value[1],"o",color=colors[i])
    m[i] = m.pop(key)
    
m
def onclick(event):
    point = [event.xdata,event.ydata]
    color = colors[kNN(point, 5)] + "^"
    ax.plot([event.xdata],[event.ydata],color)
    plt.draw()

def kNN(x,k):
    votes = []
    for list in m.viewvalues():
        for point in list:
            sqr_dist = (point[0]-x[0])**2 + (point[1]-x[1])**2
            vote = []
            vote.append(sqr_dist)
            vote.append(point[2])
            votes.append(vote)
    votes.sort()
    print votes
    k_vote = [0]*(len(m))
    
    for i in range(0,k):
        k_vote[int(votes[i][1])] += 1
    print k_vote
    return k_vote.index(max(k_vote))
cid = fig.canvas.mpl_connect('button_press_event', onclick)



 
plt.show()




