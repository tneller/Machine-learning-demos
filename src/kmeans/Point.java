
public class Point
{
	private double x,y;
	public Point(double x,double y)
	{
		this.x = x;
		this.y = y;
	}
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
	public boolean equals(Point p) 
	{
		return ((this.x == p.x) && (this.y == p.y));
	}
	public void print()
	{
		System.out.print("("+x+","+y+")");
	}
}
