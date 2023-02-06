package algorithm.c4;

public class S424 {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxCount = 0; // 当前窗口内字母的最大次数
        int left = 0, right = 0;
        char[] chars = new char[91]; // 记录窗口内各字母出现的次数
        while (right < s.length()) {
            char c = s.charAt(right); ////当前字母
            chars[c]++; // 当前字母出现的次数
            maxCount = Math.max(maxCount, chars[c]);// 窗口内所出现字母的最大次数
            // 只需要将其他字母的出现频率降到k即可
            while (right - left + 1 - maxCount > k) { // 非最大次数的字母出现次数 > k
                chars[s.charAt(left++)]--;// 窗口左移,移除元素，次数-1
            }
            res = Math.max(res, right - left + 1);
            right++; // 窗口右移
        }
        return res;
    }
}
