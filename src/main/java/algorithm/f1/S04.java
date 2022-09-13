package algorithm.f1;

public class S04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (j < n && i >= 0) {
            int val = matrix[i][j];
            if (val == target) {
                return true;
            }
            if (val > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
