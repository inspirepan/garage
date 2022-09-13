package algorithm.c14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S1477 {
    public int minSumOfLengths(int[] arr, int target) {
        // 没思路
        // 表示v之前的所有元素之和为k
        Map<Integer, Integer> map = new HashMap<>();
        // dp[i] 表示从0到i-1之间和为target的最短长度，之所以要减一是因为要设置一个没有数字的-1
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, 100001);
        int result = 100001;
        int sum = 0;
        map.put(0, 0);
        for (int i = 1; i <= arr.length; i++) {
            // 当前之前总和
            sum += arr[i - 1];
            // 溢出的值
            int dis = sum - target;
            // 如果之前的总和等于溢出的值，说明从之前的坐标到当前坐标的这一段求和为target
            if (map.containsKey(dis)) {
                int index = map.get(dis);
                int currLen = i - index;
                dp[i] = Math.min(dp[i - 1], currLen);
                result = Math.min(result, currLen + dp[index]);
            } else {
                dp[i] = dp[i - 1];
            }
            map.put(sum, i);
        }
        System.out.println(Arrays.toString(dp));
        return result == 100001 ? -1 : result;
    }
}
