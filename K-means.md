####K-means clustering

This algorithm will partition the dataset into given number of clusters by minimize the _within-cluster variation_.(However, we have use the gap statistics to infer the best K).

Definition of within-cluster variation of a cluster: sum of all distance between all pairs of observation divided by number of observations. (squared Euclidean distance is the most used measure of distance)

Initialization methods:
1. Random Partition: each observation is randomly assign to one of the clusters.
2. Foggy: randomly pick K observations as the centroid.

Algorithm(using foggy initialization):
    randomly pick K observations as the centroid
    repeat until converge: 
        assign each observation to the cluster whose centroid is closest
        recompute the centroid of each cluster

Centroid is defined as average of all observations in the cluster.

Properties of K-means algorithm:
this algorithm does not guaranteed to converge at global minimum, in other word, it will sometimes converge at a local minimum which is not a good cluster. So we need to iterate the algorithm many times at different random states to get better results(smaller within-cluster variation), but it is still not guaranteed to find the global minimum.

