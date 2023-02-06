package algorithm.c6;

public class S688dfs {

    private static final int[] dr = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] dc = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};

    public double knightProbability(int n, int k, int row, int column) {
        // 模拟题 —— 直接dfs模拟超时了 哎
        // 要用dp来记录状态
        // 其实给dfs加一个记忆化的应该也可以过
        return dfs(0, row, column, n, k);
    }

    private double dfs(int steps, int r, int c, int n, int k) {
        if (steps == k) {
            if (c >= 0 && c < n && r >= 0 && r < n) {
                return 1;
            } else {
                return 0;
            }
        }
        double probs = 0;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nc >= 0 && nc < n && nr >= 0 && nr < n) {
                probs += dfs(steps + 1, nr, nc, n, k);
            }
        }
        return probs / 8;
    }
}
