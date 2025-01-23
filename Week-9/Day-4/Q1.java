import java.util.*;

public class Q1 {
    public static double closestPair(int[][] points) {
        if (points.length <= 1) return 0.0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        return closestPairRec(points, 0, points.length - 1);
    }
    
    private static double closestPairRec(int[][] points, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }
        
        int mid = left + (right - left) / 2;
        int[] midPoint = points[mid];
        
        double leftDist = closestPairRec(points, left, mid);
        double rightDist = closestPairRec(points, mid + 1, right);
        
        double minDist = Math.min(leftDist, rightDist);
        
        return Math.min(minDist, merge(points, left, mid, right, minDist));
    }
    
    private static double bruteForce(int[][] points, int left, int right) {
        double minDist = Double.MAX_VALUE;
        
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                minDist = Math.min(minDist, distance(points[i], points[j]));
            }
        }
        return minDist;
    }
    
    private static double merge(int[][] points, int left, int mid, int right, double minDist) {
        List<int[]> strip = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i][0] - points[mid][0]) < minDist) {
                strip.add(points[i]);
            }
        }
        
        double min = minDist;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && strip.get(j)[1] - strip.get(i)[1] < min; j++) {
                min = Math.min(min, distance(strip.get(i), strip.get(j)));
            }
        }
        
        return min;
    }
    
    private static double distance(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {3, 4}, {1, 1}, {10, 10}, {20, 20}};
        System.out.println("Closest Pair Distance: " + closestPair(points)); // Output: 1.4142135623730951
    }
}
