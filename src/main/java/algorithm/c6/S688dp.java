package algorithm.c6;

import java.util.Arrays;

public class S688dp {
    private static final int[] dx = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] dy = new int[] {-2, -1, 1, 2, -2, -1, 1, 2};

    public double knightProbability(int n, int k, int row, int column) {
        // dp[i][j][k] 为坐标ij在k步操作后留在棋盘的概率
        // 初始状态0步全为1
        // 简化、只需要保留上一步的dp数组、更新当前的dp数组即可
        double[][] prob = new double[n][n];
        for (var p : prob) {
            Arrays.fill(p, 1);
        }
        while (k-- > 0) {
            double[][] newProb = new double[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    double p = 0;
                    for (int s = 0; s < 8; s++) {
                        int nx = x + dx[s], ny = y + dy[s];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            p += prob[nx][ny];
                        }
                    }
                    newProb[x][y] = p / 8;
                }
            }
            prob = newProb;
        }
        return prob[row][column];
    }
}
