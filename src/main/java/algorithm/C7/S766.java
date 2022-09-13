package algorithm.C7;

public class S766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int curr = matrix[i][0];
            int x = i + 1;
            int y = 1;
            while (x < m && y < n) {
                if (matrix[x][y] != curr) {
                    return false;
                }
                x++;
                y++;
            }
        }
        for (int j = 1; j < n; j++) {
            int curr = matrix[0][j];
            int x = 1;
            int y = j + 1;
            while (x < m && y < n) {
                if (matrix[x][y] != curr) {
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }
}
