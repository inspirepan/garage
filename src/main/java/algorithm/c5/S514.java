package algorithm.c5;

import java.util.ArrayList;
import java.util.List;

public class S514 {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        int[][] dp = new int[m][n + 1];
        List<List<Integer>> index = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            index.add(new ArrayList<>());
        }
        char[] arr = ring.toCharArray();
        for (int i = 0; i < m; i++) {
            index.get(arr[i] - 'a').add(i);
        }
        for (int j = n - 1; j >= 0; j--) {
            char curr = key.charAt(j);
            for (int i = 0; i < m; i++) {
                int min = Integer.MAX_VALUE;
                for (int k : index.get(curr - 'a')) {
                    int t = Math.abs(i - k);
                    min = Math.min(min, Math.min(t, m - t) + dp[k][j + 1]);
                }
                dp[i][j] = min;
            }
        }
        // n次确认
        return dp[0][0] + n;
    }
}
