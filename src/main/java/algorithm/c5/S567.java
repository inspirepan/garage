package algorithm.c5;

import java.util.Arrays;

public class S567 {
    public boolean checkInclusion(String s1, String s2) {
        // 维护固定长度的一个滑动窗口，窗口中的字母组合数量如果恰好等于s1的字母组合，返回true
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] s1chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1chars[s1.charAt(i) - 'a']++;
        }
        int[] s2window = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s2window[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1chars, s2window)) {
            return true;
        }
        int left = 0;
        int right = s1.length() - 1;
        while (right < s2.length() - 1) {
            s2window[s2.charAt(left++) - 'a']--;
            s2window[s2.charAt(++right) - 'a']++;
            if (Arrays.equals(s1chars, s2window)) {
                return true;
            }
        }
        return false;
    }
}
