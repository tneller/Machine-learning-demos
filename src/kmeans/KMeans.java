import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
public class KMeans 
{	
	// Nine colors for plotting 
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
	/**
	 * Randomly assign points to clusters
	 * @param list
	 * @param k
	 * @return Array of lists; Each list contains a cluster of points
	 */
	public static LinkedList<Point>[] randomPartition(LinkedList<Point> list,int k)
	{
		LinkedList<Point>[] clusters = new LinkedList[k];
		for(int i = 0;i<k;i++)
		{
			clusters[i] = new LinkedList<Point>();
		}
		Random rand = new Random();
		for(Point p:list)
		{
			int c = rand.nextInt(k);
			clusters[c].add(p);
		}
		return clusters;
	}
	/**
	 * Computes centroids of clusters
	 * @param clusters
	 * @param centroids
	 * @return Array of cnetroids
	 */
	public static Point[] computeCentroid(LinkedList<Point>[] clusters, Point[] centroids)
	{
		for(int i = 0;i<clusters.length;i++)
		{
			double sumX = 0;
			double sumY = 0;
			for(Point p:clusters[i])
			{
				sumX += p.getX();
				sumY += p.getY();
			}
			centroids[i] = new Point(sumX/clusters[i].size(),sumY/clusters[i].size());
		}
		return centroids;
	}
	/**
	 * Assign data points to the cluster of closest centroid
	 * @param clusters
	 * @param centroids
	 */
	public static void reassign(LinkedList<Point>[] clusters, Point[] centroids)
	{
		for(int i = 0;i<clusters.length;i++)
		{
			LinkedList<Point> cluster = clusters[i];
			for(int j = 0;j<cluster.size();)
			{
				int index = 0;
				Point p = cluster.get(j);
				double dist = Double.POSITIVE_INFINITY;
				for(int k = 0;k<centroids.length;k++)
				{
					double d = computeDist(p,centroids[k]);
					if(dist > d)
					{
						dist = d;
						index = k;
					}
				}
				if(i!=index)
				{
					clusters[index].add(p);
					cluster.remove(p);
				}
				else
				{
					j++;
				}
			}
		}
	}
	/**
	 * Computes distance of two points
	 * @param a
	 * @param b
	 * @return
	 */
	public static double computeDist(Point a,Point b)
	{
		return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
	}
	/**
	 * Iteratively computes the clusters
	 * @param data
	 * @param k
	 * @return Cluster with least inner distance among all iterations
	 */
	public static Clusters iterativeCluster(LinkedList<Point> data,int k)
	{
		boolean converged = false;
		Clusters iteration = new Clusters();
		LinkedList<Point>[] clusters = randomPartition(data,k);
		Point[] centroids = new Point[k];
		centroids = computeCentroid(clusters,centroids);
		double dist = computeInnerDist(clusters,centroids);
		while(!converged)
		{
			reassign(clusters, centroids);
			centroids = computeCentroid(clusters,centroids);
			double innerDist = computeInnerDist(clusters, centroids);
			if(dist != innerDist)
			{
				dist = innerDist;
			}
			else
			{
				converged = true;
			}
			
		}
		iteration.setInnerDist(dist);
		iteration.setCentroids(centroids);
		iteration.setClusters(clusters);
		return iteration;
	}
	/**
	 * Computes the inner distance of a clustering
	 * @param clusters
	 * @param centroids
	 * @return the distance
	 */
	public static double computeInnerDist(LinkedList<Point>[] clusters,Point[] centroids) 
	{
		double innerDist = 0;
		for(int i = 0;i<clusters.length;i++)
		{
			for(Point p: clusters[i])
			{
				innerDist += computeDist(p, centroids[i]);
			}
		}
		return innerDist;
	}
	/**
	 * Plots the clustering
	 * @param iteration
	 */
	
	public static void plot(Clusters iteration)
	{
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setSize(600, 600);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);
		frame.add(panel);
		Graphics g = panel.getGraphics();
		
		LinkedList<Point>[] clusters = iteration.getClusters();
		int k = clusters.length;
		Point[] centroids = iteration.getCentroids();
		for(int i = 0;i<k;i++)
		{
			LinkedList<Point> cluster = clusters[i];
			g.setColor(COLORS[i]);
			for(Point p: cluster)
			{
				g.drawOval(Math.round((float)(p.getX()*600)), Math.round((float)(p.getY()*600)), 3, 3);
			}
			g.setColor(Color.BLACK);
			g.fillOval((int)(centroids[i].getX()*600), (int)(centroids[i].getY()*600), 10, 10);
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Computes the range of normally distributed data
	 * @param data
	 * @return the array of range
	 */
	public static double[] boundingBox(LinkedList<Point> data) 
	{
		double[] box = new double[4];
		box[0] = data.getFirst().getX();
		box[1] = data.getFirst().getX(); 
		box[2] = data.getFirst().getY();
		box[3] = data.getFirst().getY(); 
		for(Point p:data)
		{
			if(p.getX()<box[0])
			{
				box[0] = p.getX();
			}
			if(p.getX()>box[1])
			{
				box[1] = p.getX();
			}
			if(p.getY()<box[2])
			{
				box[2] = p.getY();
			}
			if(p.getY()>box[3])
			{
				box[3] = p.getY();
			}
		}
		return box;
	}
	/**
	 * Generates normally distributed data set
	 * @param range
	 * @param num
	 * @return list of random data set
	 */
	private static LinkedList<Point> generateSample(double[] range,int num) 
	{
		LinkedList<Point> sample = new LinkedList<Point>();
		Random rand = new Random();
		for(int i = 0;i<num;i++)
		{
			double x = range[0] + (range[1] - range[0]) * rand.nextDouble();
			double y = range[2] + (range[3] - range[2]) * rand.nextDouble();
			sample.add(new Point(x,y));
		}
		return sample;
	}
	/**
	 * Clusters data points with k-means algorithm
	 * @param data
	 * @param k
	 * @return best clustering iteration
	 */
	public static Clusters kmeans(LinkedList<Point> data, int k)
	{
		double innerDist = Double.POSITIVE_INFINITY;
		Clusters bestIter = new Clusters();
		for(int i = 0;i<100;i++)
		{
			Clusters iteration = iterativeCluster(data,k);
			if(iteration.getInnerDist() < innerDist)
			{
				innerDist = iteration.getInnerDist();
				System.out.println(innerDist);
				bestIter = iteration;
			}
		}
		return bestIter;
	}
	public static void main(String[] args) 
	{
		try 
		{
			LinkedList<Point> data = loadData("data/easygaussian4.dat");
			double[] range = boundingBox(data);
			Clusters bestIter = new Clusters();
			double gap = 0;
			for(int i = 1;i<=9;i++)
			{
				double sampleWk = 0;
				for(int j = 0;j<30;j++)
				{
					sampleWk += kmeans(generateSample(range,data.size()),i).getInnerDist();
				}
				sampleWk /= 30;
				Clusters iteration= kmeans(data,i);
				double dataWk = iteration.getInnerDist();
				double currGap = Math.log(sampleWk)-Math.log(dataWk);
				if(gap < currGap)
				{
					gap = currGap;
					bestIter = iteration;
				}
			}
			plot(bestIter);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}	
}