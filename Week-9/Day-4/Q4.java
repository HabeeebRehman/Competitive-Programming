import java.util.*;

public class Q4 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Function to calculate the distance between two points
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    // Function to calculate the area of a triangle formed by 3 points
    public static double triangleArea(Point a, Point b, Point c) {
        return Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0;
    }

    // Function to calculate the incenter of the polygon
    public static Point findIncenter(List<Point> polygon) {
        int n = polygon.size();
        double totalArea = 0;
        double cx = 0, cy = 0;
        
        // Calculate the centroid (incenter approximation for convex polygons)
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            double area = triangleArea(polygon.get(0), polygon.get(i), polygon.get(j));
            totalArea += area;
            cx += (polygon.get(i).x + polygon.get(j).x) * area;
            cy += (polygon.get(i).y + polygon.get(j).y) * area;
        }

        cx /= (3 * totalArea);
        cy /= (3 * totalArea);

        return new Point((int) cx, (int) cy);
    }

    // Function to calculate the radius of the largest inscribed circle
    public static double maxInscribedCircleRadius(List<Point> polygon) {
        Point incenter = findIncenter(polygon);
        double minDist = Double.MAX_VALUE;

        // Find the minimum distance from the incenter to any edge of the polygon
        for (int i = 0; i < polygon.size(); i++) {
            int j = (i + 1) % polygon.size();
            Point p1 = polygon.get(i);
            Point p2 = polygon.get(j);
            
            // Distance from the incenter to the line segment (edge)
            double dist = Math.abs((p2.y - p1.y) * incenter.x - (p2.x - p1.x) * incenter.y + p2.x * p1.y - p2.y * p1.x)
                    / distance(p1, p2);
            minDist = Math.min(minDist, dist);
        }

        return minDist;
    }

    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(4, 0));
        polygon.add(new Point(4, 4));
        polygon.add(new Point(0, 4));

        System.out.println("Max Inscribed Circle Radius: " + maxInscribedCircleRadius(polygon)); // Output: 2.0
    }
}
