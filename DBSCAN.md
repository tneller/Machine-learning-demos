####DBSCAN clustering

This algorithm will partition the dataset into given number of clusters by minimize the sum of _within-cluster variation_ __w__  of all clusters, denoted as __W__ .(However, we can use the gap statistic to infer the best K).

*within-cluster variation of a cluster*: sum of all distance between all pairs of observation divided by number of observations. (*squared Euclidean distance* is the most used measure of distance)

Initialization methods:

1. __Random Partition__: each observation is randomly assign to one of the clusters.
2. __Foggy__: randomly pick K observations as the centroid.

Algorithm(using foggy initialization):

1. randomly pick K observations as the centroid
2. repeat until converge: 
1. assign each observation to the cluster whose centroid is closest
2. recompute the centroid of each cluster

Centroid is defined as average of all observations in the cluster.

Properties of K-means algorithm:
* this algorithm __does not guarantee__ to converge at global minimum, in other word, it will sometimes converge at a local minimum which is not a good cluster. So we need to iterate the algorithm many times at __different random initialization__ to get better results(smaller within-cluster variation), but it is still not guaranteed to find the global minimum.
* k-means algorithms requires spherical data and clusters with similar variance.

***
#####Estimate best K by gap statistic

This method can estimate the best K(range from 1 to n) for K-means clustering

1. Apply K-means algorithm to the dataset using k = 1,...,n to compute each __W_k__
2. Uniformly generate m groups of datasets in the __bounding box__ of original data, and apply K-means algorithm to generated dataset using k = 1,...,n to compute each __W_k__, then take the average __W_k'__
3. Compute the gap of each K by the formula: Gap(k) = log(__W_k'__) - log(__W_k__)

The optimal K will have the greatest gap.

#####Examples

![](src/kmeans/pic/km1.tiff)
