import java.util.LinkedList;
/**
 * Cluster class represent iterations in K-means
 */
public class Clusters 
{
	double innerDist;//within-cluster sum of square
	LinkedList<Point>[] clusters; // data structure to store points
	Point[] centroids;//array of centroids
	
	/**
	 * getters and setters
	 */
	
	public double getInnerDist() 
	{
		return innerDist;
	}
	public void setInnerDist(double innerDist) 
	{
		this.innerDist = innerDist;
	}
	public LinkedList<Point>[] getClusters() 
	{
		return clusters;
	}
	public void setClusters(LinkedList<Point>[] clusters) 
	{
		this.clusters = clusters;
	}
	public Point[] getCentroids() 
	{
		return centroids;
	}
	public void setCentroids(Point[] centroids) 
	{
		this.centroids = centroids;
	}
}
