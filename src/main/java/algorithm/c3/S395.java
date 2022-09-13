package algorithm.c3;

public class S395 {

    /**
     * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/xiang-jie-mei-ju-shuang-zhi-zhen-jie-fa-50ri1/
     * 滑动窗口的解法，思路是强行给窗口一个右增左减的变量，窗口内的字符种类数量，从1到26遍历
     */

    public int longestSubstring(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }
        return count(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int count(char[] arr, int k, int left, int right) {
        // 如果总数小于k个
        if (right - left + 1 < k) {
            return 0;
        }
        int[] count = new int[26];
        // 统计词频
        for (int i = left; i <= right; i++) {
            count[arr[i] - 'a']++;
        }
        // 左右两侧先剔除掉词频不够的字母
        while (right - left + 1 >= k && count[arr[left] - 'a'] < k) {
            left++;
        }
        while (right - left + 1 >= k && count[arr[right] - 'a'] < k) {
            right--;
        }
        // 如果此时剩余字符小于k
        if (right - left + 1 < k) {
            return 0;
        }
        // 如果中间存在一个词频不够的字母，就再次从这里断开
        for (int i = left; i <= right; i++) {
            if (count[arr[i] - 'a'] < k) {
                return Math.max(count(arr, k, left, i - 1), count(arr, k, i + 1, right));
            }
        }
        // 遍历，没有词频不够的字母，全算上
        return right - left + 1;
    }
}
