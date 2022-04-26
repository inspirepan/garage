package algorithm.C8;

import java.util.Arrays;
import java.util.Map;

public class S873 {
    public int lenLongestFibSubseq(int[] arr) {
        // 思路就是dp，看每一个位置的元素能不能接到之前的子序列中去
        // 每个子序列需要最后两位确定，因此使用二维数组dp就可以了
        // 其实没有那么难啊
        int len = arr.length;
        int max = 0;
        int[][] dp = new int[len][len];
        for (int[] row : dp) Arrays.fill(row, 2);
        // 因为是有序的
        for (int i = 2; i < len; i++) {
            int curr = arr[i];
            int left = 0;
            int right = len - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == curr) {
                    dp[right][i] = Math.max(dp[right][i], dp[left][right] + 1);
                    max = Math.max(max, dp[right][i]);
                    left++;
                    right--;
                } else if (sum > curr) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return max;
    }
}
