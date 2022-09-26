package algorithm.c7;

public class S788 {
    public int rotatedDigits(int n) {
        // 三类数
        // 1: 旋转后不同
        // 0： 旋转后相同
        // -1： 不能旋转
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
