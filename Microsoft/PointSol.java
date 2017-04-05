import java.util.*;
public class PointSol {
    public static void main(String[] args){
        Set<Point> allPoints = new HashSet<Point>();
        Point p1 = new Point();
        p1.x = 1;
        p1.y = 1;
        Point p2 = new Point();
        p2.x = 0;
        p2.y = 1;
        Point p3 = new Point();
        p3.x = 15;
        p3.y = 5;
        Point p4 = new Point();
        p4.x = 6;
        p4.y = 3;
        allPoints.add(p1);
        allPoints.add(p2);
        allPoints.add(p3);
        allPoints.add(p4);
        Point referencePoint = new Point();
        referencePoint.x=0;
        referencePoint.y=0;
        int k = 2;
        Set<Point> res = FindClosestPoints(allPoints,referencePoint,k);
        for(Point point : res){
            System.out.println(point.x +" " +point.y);
        }
    }
    
    public static Set<Point> FindClosestPoints(Set<Point> allPoints, Point referencePoint, int k)
    {
    	double max = Double.MIN_VALUE;
    	Set<Point> res = new HashSet<Point>();
    	TreeMap<Double,Point> map = new TreeMap<Double,Point>();
    	int count = 0;
    	for(Point p : allPoints)
    	{
    		double currDist = calculateDistance(referencePoint, p);
    		if(count<k)
    		{
    			map.put(currDist,p);
    			if(currDist>max)
    				max = currDist;
    		}
    		else
    		{
    			if(currDist<max)
    			{
    				map.remove(max);
    				map.put(currDist,p);
    				max = currDist;
    			}
    		}
    		
    	count++;
    	}
    	
        for (Map.Entry<Double, Point> entry : map.entrySet()) {
             res.add(entry.getValue());
            }
        return res;
    }

    public static double calculateDistance(Point p1, Point p2)
    {
	    double d = 0;
	    d = Math.sqrt(Math.pow((p1.x - p2.x),2) + Math.pow((p1.y - p2.y),2)); 
	    // Only need distance
	    return Math.abs(d);
    }
}