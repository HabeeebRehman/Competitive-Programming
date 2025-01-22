public class Q2 {
    public static void main(String[] args) {
        int[][] graph = {{0, 3, INF, INF}, {INF, 0, 1, INF}, {INF, INF, 0, 7}, {2, INF, INF, 0}};
        floydWarshall(graph);
    }

    static final int INF = 99999;

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}
