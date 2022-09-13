package algorithm.c7;

import java.util.Arrays;

public class S723 {
    int m;
    int n;

    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        int[][] candyToCrush = new int[m][n];
        while (checkSable(board, candyToCrush)) {
            drop(board, candyToCrush);
        }
        return board;
    }

    private boolean checkSable(int[][] board, int[][] candyToCrush) {
        // check if stable, find candy to crush
        for (int[] t : candyToCrush) {
            Arrays.fill(t, 0);
        }
        boolean flag = false;
        // check row
        for (int i = 0; i < m; i++) {
            int p = 0;
            while (p < n) {
                int q = p;
                while (p < n && board[i][p] == board[i][q]) {
                    p++;
                }
                // [q,p-1]
                if (p > q + 2 && board[i][q] != 0) {
                    // 如果连续的长度大于3，crush
                    flag = true;
                    int t = q;
                    while (t < p) {
                        candyToCrush[i][t++] = 1;
                    }
                }
            }
        }
        // check col
        for (int j = 0; j < n; j++) {
            int p = 0;
            while (p < m) {
                int q = p;
                while (p < m && board[p][j] == board[q][j]) {
                    p++;
                }
                if (p > q + 2 && board[q][j] != 0) {
                    flag = true;
                    int t = q;
                    while (t < p) {
                        candyToCrush[t++][j] = 1;
                    }
                }
            }
        }
        return flag;
    }

    private void drop(int[][] board, int[][] candyToCrush) {
        // drop candies according to candyToCrush
        // 根据每一列来drop，空位补0
        for (int j = 0; j < n; j++) {
            int b = m - 1;
            int d = m - 1;
            while (b >= 0 && d >= 0) {
                if (candyToCrush[d][j] == 0) {
                    board[b--][j] = board[d][j];
                }
                d--;
            }
            while (b >= 0) {
                // 空位补0
                board[b--][j] = 0;
            }
        }
    }
}
