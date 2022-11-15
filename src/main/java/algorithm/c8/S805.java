package algorithm.c8;

/**
 * @author : panjixiang
 * @since : 2022/11/14
 */
public class S805 {
    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            // 思路上来说，不管怎么样都是将nums分成两组，由于是int数组并且要求平均值一样，由于是int数组，所以可以考虑计算sum/len*k能不能找到k个数即可 0<k<len
            // 但是这样子要计算很多次？
            // 可以利用是整数的特点排除部分case
            int sum = 0;
            int n = nums.length;
            for (int num : nums) {
                sum += num;
            }
            // 表示能否找到和为i的j个数
            // 第二个维度用int的32位表示 —— 要对题目条件中30左右的限制更加敏感
            int[] dp = new int[sum + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = sum; i >= num; i--) {
                    if (dp[i - num] != 0) {
                        dp[i] |= (dp[i - num] << 1);
                    }
                }
            }
            for (int i = 1; i <= n / 2; i++) {
                if (sum * i % n == 0 && ((dp[sum * i / n] & (1 << i)) > 0)) {
                    return true;
                }
            }
            return false;
        }
    }
}
