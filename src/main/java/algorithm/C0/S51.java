package algorithm.C0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S51 {
    List<List<String>> result = new ArrayList<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(0);
        return result;
    }

    private void dfs(int r) {
        // 插入第r行的皇后
        if (r == board.length) {
            List<String> currBoard = new ArrayList<>();
            for (char[] row : board) {
                currBoard.add(new String(row));
            }
            result.add(currBoard);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (checkAvailable(r, i)) {
                board[r][i] = 'Q';
                dfs(r + 1);
                board[r][i] = '.';
            }
        }
    }

    private boolean checkAvailable(int r, int c) {
        // 检查是否冲突
        if (r == 0) {
            return true;
        }
        // 检查列
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        // 检查斜线
        int i = r - 1, j = c - 1;
        while (i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q') {
                return false;
            }
        }
        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < board.length) {
            if (board[i--][j++] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
