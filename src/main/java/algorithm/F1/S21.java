package algorithm.F1;

public class S21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            while (l < len && (nums[l] & 1) == 1) {
                l++;
            }
            while (r >= 0 && (nums[r] & 1) == 0) {
                r--;
            }
            if (l > r) {
                return nums;
            }
            swap(l, r, nums);
            l++;
            r--;
        }
        return nums;
    }

    private void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
