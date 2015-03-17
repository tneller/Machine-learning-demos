import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DBScan 
{
	static LinkedList<Point> data;
	static Color [] COLORS = {Color.magenta,Color.cyan,Color.gray,Color.green,Color.red,Color.pink,Color.yellow,Color.blue,Color.orange};
	/**
	 * Load data from given file
	 * @param filename
	 * @return List of data points
	 * @throws IOException
	 */
	public static LinkedList<Point> loadData(String filename) throws IOException
	{
		FileReader r = new FileReader(filename);
		BufferedReader reader = new BufferedReader(r);
		String line = reader.readLine();
		line = reader.readLine();
		line = reader.readLine();
		LinkedList<Point> list = new LinkedList<Point>();
		while(line!=null)
		{
			String[] data = line.split(" ");
			Double x = new Double(data[0]);
			Double y = new Double(data[1]);
			list.add(new Point(x,y));
			line = reader.readLine();
		}
		reader.close();
		return list;
	}


	public static void DBSCAN(LinkedList<Point> data, double dist, int n)
	{
		ArrayList<LinkedList<Point>> clusters = new ArrayList<LinkedList<Point>>();
		LinkedList<Point> cluster = new LinkedList<Point>();
		clusters.add(cluster);
		int count = 1;
		for(Point p:data)
		{
			if(!p.isVisited())
			{
				p.visit();
				LinkedList<Point> neighbor = regionQuery(p, dist);
				if (neighbor.size() < n)
				{
					p.setCluster(-1);
				}
				else
				{
					count++;
					expandCluster(count,p,neighbor, dist, n);
				}
			}

		}
	}
	public static void expandCluster(int ClusterCount,Point p , LinkedList<Point> neighbor , double dist , int n)
	{
		p.setCluster(ClusterCount);
		for(int i = 0;i<neighbor.size();i++)
		{
			Point point = neighbor.get(i);
			if(!point.isVisited())
			{
				point.visit();
				LinkedList<Point> newNeighbor = regionQuery(point, dist);
				if (newNeighbor.size() >= n)
				{
					neighbor.addAll(newNeighbor);
				}
			}
			if(point.getCluster() == 0)
			{
				point.setCluster(ClusterCount);
			}
		}
	}
	public static double computeDist(Point a,Point b)
	{
		return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
	}
	public static LinkedList<Point> regionQuery(Point p, double dist)
	{
		LinkedList<Point> list = new LinkedList<Point>();
		for(Point point:data)
		{
			double d = computeDist(p, point);
			if(!p.equals(point) && d<=dist)
			{
				list.add(point);
			}
		}
		return list;
	}

	public static void main(String[] args)
	{
		try 
		{
			data = loadData("data/diffdensity2.dat");
			DBSCAN(data, 0.05, 2);

			JFrame frame = new JFrame();
			frame.setSize(600, 600);
			frame.setVisible(true);
			JPanel panel = new JPanel();
			panel.setSize(600, 600);
			panel.setBackground(Color.WHITE);
			panel.setVisible(true);
			frame.add(panel);
			Graphics g = panel.getGraphics();

			for(Point p: data)
			{
				int color = p.getCluster();
				if(color == -1)
				{
					g.setColor(Color.black);
				}
				else
				{
					g.setColor(COLORS[color]);
				}
				g.drawOval(Math.round((float)(p.getX()*600)), Math.round((float)(p.getY()*600)), 3, 3);
			}

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
