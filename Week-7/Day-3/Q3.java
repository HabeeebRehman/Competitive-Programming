import java.util.*;

public class Q3 {
    public static boolean isInside(int[][] polygon, int[] point) {
        int n = polygon.length;
        if (n < 3) return false;

        int[] extreme = {Integer.MAX_VALUE, point[1]};
        int count = 0, i = 0;

        do {
            int next = (i + 1) % n;

            if (doIntersect(polygon[i], polygon[next], point, extreme)) {
                if (orientation(polygon[i], point, polygon[next]) == 0) {
                    return onSegment(polygon[i], point, polygon[next]);
                }
                count++;
            }
            i = next;
        } while (i != 0);

        return count % 2 == 1;
    }


    public static void main(String[] args) {
        int[][] polygon = {{0, 0}, {10, 0}, {10, 10}, {0, 10}};
        int[] point = {5, 5};
        System.out.println(isInside(polygon, point));
    }
}
