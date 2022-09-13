package algorithm.C6;

public class S651 {

    int max = 0;

    public int maxA(int n) {
        // 要记录复制的数量，关键是可以多次粘贴
        // 一次A+C之后可以多次V
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];
            // 也可以通过多次粘贴而来，干脆就遍历呗
            for (int j = 2; j < i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - 1 - j));
            }
        }
        return dp[n];
    }

    private void dfs(int step, int count, int copiedCount, int n) {
        // 会超时
        if (step == n) {
            max = Math.max(max, count);
            return;
        }
        if (step > n) {
            return;
        }
        // A
        dfs(step + 1, count + 1, copiedCount, n);
        // Ctrl V
        dfs(step + 1, count + copiedCount, copiedCount, n);
        // Ctrl A+C
        dfs(step + 2, count, count, n);
    }
}
