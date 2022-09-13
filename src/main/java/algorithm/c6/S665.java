package algorithm.c6;

public class S665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int index = 0;
        int greater = 0;
        int less = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= prev) {
                greater++;
            } else {
                less++;
                index = i;
            }
            prev = nums[i];
        }

        if (less == 1) {
            if (nums.length <= 3) {
                return true;
            } else {
                if (index == 1 || index == nums.length - 1) {
                    return true;
                } else {
                    return nums[index - 1] <= nums[index + 1] || nums[index - 2] <= nums[index];
                }
            }
        } else {
            return less == 0;
        }
    }
}
