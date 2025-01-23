import java.util.*;

public class Q5 {
    static class UnionFind {
        Map<String, String> parent;
        Map<String, Double> weight;

        UnionFind() {
            parent = new HashMap<>();
            weight = new HashMap<>();
        }

        public void add(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                weight.put(x, 1.0);
            }
        }

        public String find(String x) {
            if (!x.equals(parent.get(x))) {
                String originalParent = parent.get(x);
                parent.put(x, find(originalParent));
                weight.put(x, weight.get(x) * weight.get(originalParent));
            }
            return parent.get(x);
        }

        public void union(String x, String y, double value) {
            add(x);
            add(y);

            String rootX = find(x);
            String rootY = find(y);

            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY);
                weight.put(rootX, value * weight.get(y) / weight.get(x));
            }
        }

        public double isConnected(String x, String y) {
            if (!parent.containsKey(x) || !parent.containsKey(y)) return -1.0;

            String rootX = find(x);
            String rootY = find(y);

            if (!rootX.equals(rootY)) return -1.0;

            return weight.get(x) / weight.get(y);
        }
    }

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        UnionFind uf = new UnionFind();

        for (int i = 0; i < equations.length; i++) {
            String var1 = equations[i][0];
            String var2 = equations[i][1];
            double value = values[i];
            uf.union(var1, var2, value);
        }

        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String var1 = queries[i][0];
            String var2 = queries[i][1];
            results[i] = uf.isConnected(var1, var2);
        }

        return results;
    }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

        double[] results = calcEquation(equations, values, queries);
        System.out.println("Query Results: " + Arrays.toString(results));
        // Output: [6.0, 0.5, -1.0, 1.0, -1.0]
    }
}
