import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(n, new ArrayList<>(), result, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }

    private static void solveNQueens(int n, List<String> current, List<List<String>> result, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(current.size() - col) || diag2.contains(current.size() + col)) continue;
            current.add(createRow(n, col));
            cols.add(col);
            diag1.add(current.size() - col);
            diag2.add(current.size() + col);
            solveNQueens(n, current, result, cols, diag1, diag2);
            current.remove(current.size() - 1);
            cols.remove(col);
            diag1.remove(current.size() - col);
            diag2.remove(current.size() + col);
        }
    }

    private static String createRow(int n, int col) {
        char[] row = new char[n];
        Arrays.fill(row, '.');
        row[col] = 'Q';
        return new String(row);
    }
}
