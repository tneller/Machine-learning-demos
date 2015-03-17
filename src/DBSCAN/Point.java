
public class Point
{
	private double x,y;
	private int cluster;
	private boolean visited;
	public Point(double x,double y)
	{
		this.x = x;
		this.y = y;
		visited = false;
		int cluster = 0;
	}
	public int getCluster() {
		return cluster;
	}
	public void setCluster(int cluster) {
		this.cluster = cluster;
	}
	public double getX() 
	{
		return x;
	}
	public void setX(double x) 
	{
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) 
	{
		this.y = y;
	}
	public boolean equals(Point p) 
	{
		return ((this.x == p.x) && (this.y == p.y));
	}
	public void print()
	{
		System.out.print("("+x+","+y+")");
	}
	public boolean isVisited() 
	{
		return visited;
	}
	public void visit() 
	{
		visited = true;
	}
}
