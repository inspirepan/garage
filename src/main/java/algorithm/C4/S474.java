package algorithm.C4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S474 {
    int max = 0;

    public int findMaxForm2(String[] strs, int m, int n) {
        if (strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];// dp[i][j]表示使用i个0和j个1能表示的字符串的最大数量
        for (String s : strs) {
            // 状态转移方程：dp[i][j] = Math.max(dp[i][j],1+dp[i-numZero][j-numOne])
            int zeros = 0, ones = 0;// 统计字符串中一和零
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // 挑最多个数组中的元素，限制是m个0和n个1
        List<int[]> count = new ArrayList<>();
        // 统计strs中的每个元素的1和0数量，然后dfs超时了
        for (String s : strs) {
            int count1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    count1++;
                }
            }
            int count0 = s.length() - count1;
            count.add(new int[] {count0, count1});
        }
        Collections.sort(count, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] > b[1] ? 1 : -1;
            } else {
                return a[0] > b[0] ? 1 : -1;
            }
        });
        dfs(count, 0, 0, 0, m, n, 0);
        return max;
    }

    private void dfs(List<int[]> count, int index, int sum0, int sum1, int m, int n, int choosed) {
        max = Math.max(choosed, max);

        if (index == count.size()) {
            return;
        }
        int curr0 = count.get(index)[0];
        int curr1 = count.get(index)[1];
        if (sum0 + curr0 <= m && sum1 + curr1 <= n) {
            dfs(count, index + 1, sum0 + curr0, sum1 + curr1, m, n, choosed + 1);
        }
        dfs(count, index + 1, sum0, sum1, m, n, choosed);
    }
}
