package algorithm.S201to300;

public class S240 {
    /**
     * 一开始的思路，多次二分搜索
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int low1 = 0, high1 = matrix.length - 1;
        while (low1 <= high1) {
            int mid1 = low1 + (high1 - low1) / 2;
            int midVal1 = matrix[mid1][0];
            if (midVal1 == target) return true;
            else if (midVal1 > target) {
                high1 = mid1;
            } else {
                low1 = mid1 + 1;
            }
        }
        int low2 = 0, high2 = matrix.length - 1;
        while (low2 <= high2) {
            int mid2 = low2 + (high2 - low2) / 2;
            int midVal2 = matrix[mid2][matrix[0].length - 1];
            if (midVal2 == target) return true;
            else if (midVal2 > target) {
                high2 = mid2;
            } else {
                low2 = mid2 + 1;
            }
        }
        int up = low2, down = low1 - 1;
        for (int i = up; i <= down; i++) {
            if (binarySearchRow(matrix, target, i)) return true;
        }
        return false;
    }

    private boolean binarySearchRow(int[][] matrix, int target, int row) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[row][mid];
            if (midVal == target) return true;
            else if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 看的别人的记录
     * 意思是说我二分搜索还没有别人遍历来得快
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return helper(matrix, target, matrix[0].length - 1, 0);
    }

    public boolean helper(int[][] matrix, int target, int col, int row) {
        int value = matrix[row][col];
        while (0 <= col && row <= matrix.length - 1) {
            value = matrix[row][col];
            if (target == value) return true;
            if (target < value) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
