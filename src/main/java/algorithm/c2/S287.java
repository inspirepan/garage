package algorithm.c2;

public class S287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            // 用正负做标记
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] *= -1;
        }
        return 0;
    }
}
