package algorithm.c2;

public class S289 {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] dp = new int[m][n];
        int[] dx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
        // 先遍历一遍，每一个活细胞把周围一圈都+1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int x = dx[k] + i;
                        int y = dy[k] + j;
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            dp[x][y]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (dp[i][j] < 2 || dp[i][j] > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (dp[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}
