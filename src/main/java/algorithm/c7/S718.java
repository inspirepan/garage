package algorithm.c7;

public class S718 {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    int t = dp[i][j] + 1;
                    max = Math.max(max, t);
                    dp[i + 1][j + 1] = t;
                }
            }
        }
        return max;
    }
}
