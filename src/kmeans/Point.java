/**
 * Point class
 */
public class Point
{
	private double x,y;
	public Point(double x,double y)
	{
		this.x = x;
		this.y = y;
	}
	//getters and setters
	public double getX() 
	{
		return x;
	}
	public void setX(double x) 
	{
		this.x = x;
	}
	public double getY() 
	{
		return y;
	}
	public void setY(double y) 
	{
		this.y = y;
	}
	// return true if two points are equal
	public boolean equals(Point p) 
	{
		return ((this.x == p.x) && (this.y == p.y));
	}
	public void print()
	{
		System.out.print("("+x+","+y+")");
	}
}
