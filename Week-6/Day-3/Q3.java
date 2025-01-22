import java.util.*;
public class Q3 {
    public double closestPair(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        return closestPairRec(points, 0, points.length - 1);
    }
    
    private double closestPairRec(int[][] points, int left, int right) {
        if (right - left <= 3) return bruteForce(points, left, right);
        
        int mid = (left + right) / 2;
        double d = Math.min(closestPairRec(points, left, mid), closestPairRec(points, mid + 1, right));
        
        List<int[]> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i][0] - points[mid][0]) < d) {
                strip.add(points[i]);
            }
        }
        
        return Math.min(d, stripClosest(strip, d));
    }
    
    private double bruteForce(int[][] points, int left, int right) {
        double min = Double.MAX_VALUE;
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                min = Math.min(min, distance(points[i], points[j]));
            }
        }
        return min;
    }
    
    private double distance(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
    
    private double stripClosest(List<int[]> strip, double d) {
        double min = d;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && strip.get(j)[1] - strip.get(i)[1] < min; j++) {
                min = Math.min(min, distance(strip.get(i), strip.get(j)));
            }
        }
        return min;
    }
}
