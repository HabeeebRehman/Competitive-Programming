import java.util.*;

public class Q3 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        solve(0, board, result);
        return result;
    }

    private static void solve(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            result.add(buildSolution(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValid(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private static List<String> buildSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("N-Queens Solutions: " + solveNQueens(n));
    }
}
