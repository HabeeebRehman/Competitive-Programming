import java.util.*;

public class Q2 {
    public static List<int[]> convexHull(int[][] points) {
        List<int[]> result = new ArrayList<>();
        
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        Stack<int[]> lower = new Stack<>();
        for (int[] p : points) {
            while (lower.size() >= 2 && crossProduct(lower.peek(), lower.get(lower.size() - 2), p) <= 0) {
                lower.pop();
            }
            lower.push(p);
        }
        
        Stack<int[]> upper = new Stack<>();
        for (int i = points.length - 1; i >= 0; i--) {
            while (upper.size() >= 2 && crossProduct(upper.peek(), upper.get(upper.size() - 2), points[i]) <= 0) {
                upper.pop();
            }
            upper.push(points[i]);
        }
        
        lower.pop();
        upper.pop();
        
        result.addAll(lower);
        result.addAll(upper);
        
        return result;
    }
    
    private static int crossProduct(int[] o, int[] a, int[] b) {
        return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0]);
    }
    
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 1}, {1, 1}, {3, 3}, {2, 2}};
        List<int[]> hull = convexHull(points);
        
        for (int[] point : hull) {
            System.out.println(Arrays.toString(point));
        }
    }
}
