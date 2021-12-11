package algorithm.S0to100;

/**
 * 二分搜索查找旋转排序数组
 * 第一次做的时候写得太乱了
 * 看看这一次有没有长进
 * 这次终于理清楚了！
 */
public class S33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return searchHelper(nums, target, left, right);
    }

    private int searchHelper(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        int mid = left + (right - left) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (nums[mid] >= nums[left]) {
            // 2345 6 8901 中位数比两边界大
            if (target < nums[mid] && target >= nums[left]) {
                return binarySearch(nums, target, left, mid - 1);
            } else {
                return searchHelper(nums, target, mid + 1, right);
            }
        } else if (nums[mid] <= nums[right]) {
            // 8901 2 3456 中位数比两边界小
            if (target > nums[mid] && target <= nums[right]) {

                return binarySearch(nums, target, mid + 1, right);
            } else {
                return searchHelper(nums, target, left, mid - 1);
            }
        }
        return -1;
    }

    /**
     * 二分搜索
     */
    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
