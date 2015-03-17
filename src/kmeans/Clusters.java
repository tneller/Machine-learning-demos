import java.util.LinkedList;

public class Clusters 
{
	double innerDist;
	LinkedList<Point>[] clusters;
	Point[] centroids;
	public double getInnerDist() {
		return innerDist;
	}
	public void setInnerDist(double innerDist) {
		this.innerDist = innerDist;
	}
	public LinkedList<Point>[] getClusters() {
		return clusters;
	}
	public void setClusters(LinkedList<Point>[] clusters) {
		this.clusters = clusters;
	}
	public Point[] getCentroids() {
		return centroids;
	}
	public void setCentroids(Point[] centroids) {
		this.centroids = centroids;
	}
}
