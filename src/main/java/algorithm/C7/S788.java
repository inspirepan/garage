package algorithm.C7;

public class S788 {
    public int rotatedDigits(int n) {
        // 1-1 0-0 8-8 5-2 2-5 6-9 9-6
        // 3-4-7 是不行的
        // 必须包含2569
        // 判断1-n
        // 生成符合条件的数
        int ans = 0;
        int[] dp = new int[Math.max(11, n + 1)];
        dp[2] = dp[5] = dp[6] = dp[9] = 1;
        dp[3] = dp[4] = dp[7] = -1;
        for (int i = 0; i <= n; i++) {
            // 如果它前面全部位置的数是不行的、或者当前位是不行的
            if (dp[i / 10] == -1 || dp[i % 10] == -1) {
                dp[i] = -1;
                // 如果前面全部位置或者当前位包含了可以的数（2569至少一个）就OK
            } else if (dp[i / 10] == 1 || dp[i % 10] == 1) {
                dp[i] = 1;
                ans++;
            }
        }
        return ans;
    }
}
