package algorithm;

public class S2016 {
    public int maximumDifference(int[] nums) {
        int max = -1;
        int p = nums[0];
        int i = 1;
        while (i < nums.length) {
            if (nums[i] > p) {
                max = Math.max(nums[i] - p, max);
            } else {
                p = nums[i];
            }
            i++;
        }
        return max;
    }
}
