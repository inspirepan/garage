package algorithm;

/**
 * 两次二分查找
 */
public class S74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (high < 0) {
            return false;
        }
        int left = 0, right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[high][mid];
            if (value == target) {
                return true;
            } else if (value > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
