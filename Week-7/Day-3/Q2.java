public class Q2 {
    public static double polygonArea(int[][] points) {
        int n = points.length;
        double area = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            int x2 = points[(i + 1) % n][0], y2 = points[(i + 1) % n][1];
            area += (x1 * y2) - (y1 * x2);
        }

        return Math.abs(area) / 2.0;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {4, 0}, {4, 3}, {0, 3}};
        System.out.println(polygonArea(points)); 
    }
}
