package algorithm.C2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S279 {

    public int numSquares(int n) {
        int k = 1;
        int[] dp = new int[n + 1];
        while (k * k <= n) {
            dp[k * k] = 1;
            k++;
        }
        // k 是最大的范围内的完全平方数
        if (dp[n] == 1) return 1;
        for (int i = 2; i <= n; i++) {
            if (dp[i] == 1) continue;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
