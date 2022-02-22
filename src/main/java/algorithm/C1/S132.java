package algorithm.C1;

import java.util.Arrays;

public class S132 {
    char[] chars;

    public int minCut(String s) {
        // 看了我之前写的，不行，这种求最少分割次数，肯定不能全遍历的，要贪心/动规
        // 考虑动态规划，dp
        // 做出来了，不过还是有点蠢，差不多是双重循环，没有对判断回文串做什么优化
        // 继续优化的话，可以提前对s的回文子串做处理，记录每个位置i向两边扩展能到什么程度，
        // 然后就可以加快isPalindrome的速度
        // 懒得弄了
        int len = s.length();
        this.chars = s.toCharArray();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i < len; i++) {
            if (isPalindrome(0, i)) {
                dp[i + 1] = 0;
                continue;
            }
            int k = i;
            while (k > 0) {
                if (isPalindrome(k, i)) {
                    // {0,k-1} {k,i}
                    dp[i + 1] = Math.min(dp[i + 1], dp[k] + 1);
                }
                k--;
            }
        }
        return dp[len];
    }

    private boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}