package algorithm.S0to100;

public class S48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平镜像翻转
        int left = 0;
        int right = n-1;
        while (left < right) {
            for (int i = 0; i < n; i++) {
                swap(matrix, i, left, i, right);
            }
            left++;
            right--;
        }
        // 沿着左下-右上这条线镜像翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }
    }

    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}
