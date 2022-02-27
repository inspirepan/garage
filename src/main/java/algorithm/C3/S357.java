package algorithm.C3;

public class S357 {
    /**
     * dfs
     */
    private final boolean[] visited = new boolean[10];
    private int count = 1;

    public int countNumbersWithUniqueDigits(int n) {
        for (int i = 1; i <= n; i++) {
            dfs(0, i);
        }
        return count;
    }

    private void dfs(int s, int n) {
        if (s == n) {
            count++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (s == 0 && i == 0) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                dfs(s + 1, n);
                visited[i] = false;
            }
        }
    }

    /**
     * 评论区的dp
     * 害，是个锤子dp，就是找规律
     */
    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int ans = 10;
        for (int i = 1; i < Math.min(10, n); i++) {
            dp[i + 1] = dp[i] * (10 - i);
            ans += dp[i + 1];
        }
        return ans;
    }
}

