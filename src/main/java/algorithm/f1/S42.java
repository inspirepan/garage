package algorithm.f1;

public class S42 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int min = 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}
