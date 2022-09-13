package algorithm.c8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import playground.ArrayUtils;

/**
 * @author 官方题解
 */
public class S887 {
    Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 官方题解3，看了之后重新写一次，逆向思路，求操作N次最高能判定几层
     */
    public static int superEggDrop2(int K, int N) {
        if (N == 1) {
            return 1;
        } else if (K == 1) {
            return N;
        }
        // 操作i次，用K个鸡蛋，到几层
        int[] dp = new int[K + 1];
        for (int j = 1; j <= K; j++) {
            dp[j] = 1;
        }
        int ans = -1;
        System.out.println(Arrays.toString(dp));
        for (int i = 2; i <= N; i++) {
            for (int j = K; j >= 1; j--) {
                dp[j] += 1 + dp[j - 1];
            }
            System.out.println(Arrays.toString(dp));
            if (dp[K] >= N) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int superEggDrop3(int K, int N) {
        if (N == 1) {
            return 1;
        }
        int[][] f = new int[N + 1][K + 1];
        for (int i = 1; i <= K; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= N; ++i) {
            for (int j = 1; j <= K; ++j) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][K] >= N) {
                ans = i;
                ArrayUtils.deepPrintArray(f);
                break;
            }
        }
        return ans;
    }

    /**
     * 扔鸡蛋
     * @param K 拥有鸡蛋个数
     * @param N 总楼层高度
     * @return 确定最低高度的最小尝试次数
     */
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    public int dp(int K, int N) {
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0) {
                ans = 0;
            } else if (K == 1) {
                ans = N;
            } else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K - 1, x - 1);
                    int t2 = dp(K, N - x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(dp(K - 1, lo - 1), dp(K, N - lo)),
                    Math.max(dp(K - 1, hi - 1), dp(K, N - hi)));
            }

            memo.put(N * 100 + K, ans);
        }
        return memo.get(N * 100 + K);
    }
}