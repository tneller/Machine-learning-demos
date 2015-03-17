####hierarchical 

* Agglomerative (bottom-up): 
  * Start with all points in their own group. 
  * Until there is only one cluster, repeatedly: merge the two groups that have the smallest dissimilarity

* Divisive (top-down):
  * Start with all points in one cluster
  * Until all points are in their own cluster, repeatedly: split the group into two resulting in the biggest dissimilarity

In agglomerative hierarchical clustering, we use different linkage funtion to measure dissimilarity between clusters.

  1. Single linkage: the smallest dissimilarity between two points in opposite groups
    * fail when clusters are chaining
  2. Complete linkage:  the largest dissimilarity between two points in opposite groups
    * fail when clusters are crowding
  3. Average linkage: the average dissimilarity over all points in opposite groups
  4. Centroid linkage: the dissimilarity of centroids in opposite groups
    * easy to use
  5. Minimax linkage:  the smallest radius encompassing all points in opposite groups
    * centers are data points
