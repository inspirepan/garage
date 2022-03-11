package algorithm.C5;

import java.util.HashSet;
import java.util.Set;

public class S523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 还是用一个set，同时用一个prev记录上一个和，避免只包含单个元素，另外记录所有和的min和max方便去猜k的倍数
        // 前缀和
        // 双重循环会超时
        int prev = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        k = Math.abs(k);
        // 不能只包含一个元素！
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i > 0) {
                // check各种倍数的k与sum的组合
                int v = (max - sum) / k;
                while (sum + v * k >= min) {
                    if (set.contains(sum + v * k)) return true;
                    v--;
                }
            }
            // 加上上个数的前缀和
            // 维护set中的最大最小值；
            set.add(prev);
            min = Math.min(min, prev);
            max = Math.max(max, prev);
            prev = sum;
        }
        return false;
    }
}
