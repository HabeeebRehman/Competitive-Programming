import java.util.*;

public class Q3 {
    public static List<int[]> intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] A = {{0, 2}, {5, 10}, {13, 15}};
        int[][] B = {{1, 6}, {8, 10}, {12, 14}};
        
        List<int[]> intersections = intervalIntersection(A, B);
        
        for (int[] interval : intersections) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
