import java.util.*;
public class NQueen{
public class Solution {

    public boolean isSafe(List<String> board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void nQueens(List<String> board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                char[] rowArray = board.get(row).toCharArray();
                rowArray[j] = 'Q';
                board.set(row, new String(rowArray));
                
                nQueens(board, row + 1, n, ans);
                
                rowArray[j] = '.';
                board.set(row, new String(rowArray));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(new String(row));
        }

        nQueens(board, 0, n, ans);
        return ans;
    }
}
}