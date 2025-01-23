import java.util.*;

public class Q5 {
    
    // Function to perform triangulation on a convex polygon
    public static List<int[]> triangulatePolygon(int[][] polygon) {
        List<int[]> triangles = new ArrayList<>();
        
        int n = polygon.length;
        
        // Assuming convex polygon, we can select the first vertex as a pivot
        for (int i = 1; i < n - 1; i++) {
            // Form a triangle by selecting the first point and two adjacent points
            triangles.add(new int[]{polygon[0][0], polygon[0][1], polygon[i][0], polygon[i][1], polygon[i + 1][0], polygon[i + 1][1]});
        }
        
        return triangles;
    }

    public static void main(String[] args) {
        int[][] polygon = {{0, 0}, {4, 0}, {4, 4}, {0, 4}};
        
        List<int[]> triangles = triangulatePolygon(polygon);
        
        for (int[] triangle : triangles) {
            System.out.println(Arrays.toString(triangle));
        }
    }
}
