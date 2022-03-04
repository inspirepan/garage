package algorithm.C3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S368n {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 不需要保存全部的list，只需要记录长度就可以了，sort之后，只要能整除，就代表可以接入到之前的子集中去
        // 最后再重新生成一遍就可以了
        int len = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }
}
