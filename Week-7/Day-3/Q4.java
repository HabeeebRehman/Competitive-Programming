import java.util.*;

public class Q4 {
    public static List<int[]> convexHull(int[][] points) {
        if (points.length < 3) return Arrays.asList(points);

        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> hull = new ArrayList<>();

        for (int[] point : points) {
            while (hull.size() >= 2 && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(point);
        }

        int size = hull.size();
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() > size && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }

        hull.remove(hull.size() - 1); 
        return hull;
    }

    private static int crossProduct(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - p[1]) - (q[1] - p[1]) * (r[0] - p[0]);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 3}, {2, 2}, {1, 1}, {2, 1}, {3, 0}, {0, 0}, {3, 3}};
        List<int[]> hull = convexHull(points);
        for (int[] point : hull) {
            System.out.println(Arrays.toString(point));
        }
    }
}
