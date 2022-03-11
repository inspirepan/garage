package algorithm.C4;

public class S498 {
    public int[] findDiagonalOrder(int[][] mat) {
        // 对角线遍历
        int i = 0;
        int j = 0;
        boolean up = true;
        int p = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        if (m == 0 || n == 0) return result;
        while (p < m * n) {
            result[p++] = mat[i][j];
            // 更新ij
            if (up) {
                if (i == 0 && j != n - 1) {
                    j++;
                    up = false;
                } else if (j == n - 1) {
                    i++;
                    up = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (j == 0 && i != m - 1) {
                    i++;
                    up = true;
                } else if (i == m - 1) {
                    j++;
                    up = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}
