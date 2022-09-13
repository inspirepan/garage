package algorithm.c4;

public class S485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 1 ? 1 : 0;
        }
        int k = -1;
        int i = 0;
        int max = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                max = Math.max(max, i - k);
            } else {
                k = i;
            }
            i++;
        }
        return max;
    }
}
