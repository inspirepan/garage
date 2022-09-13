package algorithm.C6;

public class S643 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        int left = 0, right = k;
        while (right < nums.length) {
            sum += nums[right++];
            sum -= nums[left++];
            max = Math.max(max, sum);
        }
        return max / (double) k;
    }
}
