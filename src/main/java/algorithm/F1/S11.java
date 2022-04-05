package algorithm.F1;

public class S11 {
    public int minArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 因为有重复元素，所以midVal==rightVal的时候就只能降低为O(n)复杂度了，
        // 只能和right比较、并且缩right
        // 因为最小元素到right才是递增的
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}