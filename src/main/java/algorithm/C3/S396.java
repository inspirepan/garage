package algorithm.C3;

public class S396 {

    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        if (len == 2) return Math.max(nums[0], nums[1]);
        // F(i) = F(i-1) + sum - len*nums[len-i-1]
        int F = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            F += i * nums[i];
        }
        int ans = F;
        for (int i = 1; i < len; i++) {
            F += (sum - len * nums[len - i]);
            ans = Math.max(ans, F);
        }
        return ans;
    }
}
