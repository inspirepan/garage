package algorithm.C15;

import java.util.HashSet;
import java.util.Set;

public class S1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        // 动态规划超时了
        // 直接贪心就可以了，遍历一遍，找到就加上
        Set<Integer> set = new HashSet<>();
        int curSum = 0;
        int res = 0;
        set.add(0);
        for (int num : nums) {
            curSum += num;
            if (set.contains(curSum - target)) {
                // 如果当前段和减去之前某一段和为target，则符合条件，即当前curSum=上次curSum+target
                set.clear();
                set.add(0);
                curSum = 0;
                res++;
            } else {
                // 还未满足条件，保留当前段的和
                set.add(curSum);
            }
        }
        return res;
    }
}
