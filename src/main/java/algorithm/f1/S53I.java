package algorithm.f1;

public class S53I {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int count = 0;
        while (0 <= left && left < nums.length && nums[left] == target) {
            count++;
            left++;
        }
        return count;
    }
}
