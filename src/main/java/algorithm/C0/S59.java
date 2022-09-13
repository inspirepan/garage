package algorithm.C0;

public class S59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int j = 0, i = 1;
        while (i <= n * n) {
            for (int k = j; k < n - j; k++) {
                ans[j][k] = i++;
            }
            for (int k = j + 1; k < n - j; k++) {
                ans[k][n - j - 1] = i++;
            }
            for (int k = n - j - 2; k >= j; k--) {
                ans[n - j - 1][k] = i++;
            }
            for (int k = n - j - 2; k > j; k--) {
                ans[k][j] = i++;
            }
            j++;
        }
        return ans;
    }
}
