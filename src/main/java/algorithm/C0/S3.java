package algorithm.C0;

import java.util.HashMap;

public class S3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            maxLen = Math.max(maxLen, i - left);
            map.put(c, i);
        }
        return maxLen;
    }

    // 今天又重新自己写了一个滑动窗口 不错哦
    public int lengthOfLongestSubstring2(String s) {
        char[] c = s.toCharArray();
        int max = 0;
        int left = 0;
        int right = 0;
        int[] cmap = new int[200];
        while (right < c.length) {
            // 如果没出现过，那么右扩容
            if (cmap[c[right]] == 0) {
                max = Math.max(max, right - left + 1);
                cmap[c[right]]++;
                right++;
            } else {
                //左缩
                cmap[c[left]]--;
                left++;
            }
        }
        return max;
    }
}
