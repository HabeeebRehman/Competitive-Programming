import java.util.*;

public class Q1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(n, 0, new int[n], result);
        return result;
    }
    
    private void backtrack(int n, int row, int[] positions, List<List<String>> result) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] rowChars = new char[n];
                Arrays.fill(rowChars, '.');
                rowChars[positions[i]] = 'Q';
                board.add(new String(rowChars));
            }
            result.add(board);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            positions[row] = col;
            if (isValid(positions, row)) {
                backtrack(n, row + 1, positions, result);
            }
        }
    }
    
    private boolean isValid(int[] positions, int row) {
        for (int i = 0; i < row; i++) {
            if (positions[i] == positions[row] || Math.abs(positions[i] - positions[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
