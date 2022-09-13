package algorithm.C0;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 正好用上刚看的二分搜索总结
 */
public class S34 {
    /**
     * 标准的左闭右开写法
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // search left boundary
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // not found
        if (left >= nums.length || nums[left] != target) {
            return new int[] {-1, -1};
        }
        // search right boundary
        int left2 = left;
        int right2 = nums.length;
        while (left2 < right2) {
            int mid = left2 + (right2 - left2) / 2;
            if (nums[mid] == target) {
                left2 = mid + 1;
            } else if (nums[mid] < target) {
                left2 = mid + 1;
            } else {
                right2 = mid;
            }
        }
        return new int[] {left, left2 - 1};
    }

    /**
     * 两端都闭的写法
     */
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return new int[] {-1, -1};
        }
        int left2 = left;
        int right2 = nums.length - 1;
        while (left2 <= right2) {
            int mid = left2 + (right2 - left2) / 2;
            if (nums[mid] == target) {
                left2 = mid + 1;
            } else if (nums[mid] > target) {
                right2 = mid - 1;
            } else {
                left2 = mid + 1;
            }
        }
        return new int[] {left, right2};
    }
}
