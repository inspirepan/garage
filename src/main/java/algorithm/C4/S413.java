package algorithm.C4;

public class S413 {
    public int numberOfArithmeticSlices(int[] nums) {
        // 求出数组中每一个段最长的等差连续数列，然后统计能够包含的子数组数量即可
        int len = nums.length;
        if (len < 2) return 0;
        int i = 2;
        int curr = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                if (curr == 0) curr = 3;
                else curr++;
            } else {
                if (curr > 0) count += (curr - 1) * (curr - 2) / 2;
                ;
                curr = 0;
            }
            i++;
        }
        if (curr > 0) count += (curr - 1) * (curr - 2) / 2;
        return count;
    }

    public int solve2(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] dp = new int[len];
        int count = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
}
