import java.util.*;

public class Q5 {
    public static double closestPair(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0])); 
        return closestPairHelper(points, 0, points.length - 1);
    }

    private static double closestPairHelper(int[][] points, int left, int right) {
        if (right - left <= 3) return bruteForce(points, left, right);

        int mid = (left + right) / 2;
        double leftDist = closestPairHelper(points, left, mid);
        double rightDist = closestPairHelper(points, mid + 1, right);

        double minDist = Math.min(leftDist, rightDist);

        List<int[]> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i][0] - points[mid][0]) < minDist) {
                strip.add(points[i]);
            }
        }

        strip.sort(Comparator.comparingInt(a -> a[1]));
        return Math.min(minDist, stripClosest(strip, minDist));
    }

    private static double stripClosest(List<int[]> strip, double d) {
        double min = d;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j)[1] - strip.get(i)[1]) < min; j++) {
                min = Math.min(min, distance(strip.get(i), strip.get(j)));
            }
        }
        return min;
    }

    private static double bruteForce(int[][] points, int left, int right) {
        double min = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                min = Math.min(min, distance(points[i], points[j]));
            }
        }
        return min;
    }

    private static double distance(int[] p1, int[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    public static void main(String[] args) {
        int[][] points = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
        System.out.println(closestPair(points));
    }
}
