package algorithm;

import java.util.Arrays;

public class S917 {
    public String reverseOnlyLetters(String s) {
        if (s.length() <= 1) return s;
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right && left < s.length() && right >= 0) {
            if (!isLetter(chars[left])) {
                left++;
                continue;
            }
            if (!isLetter(chars[right])) {
                right--;
                continue;
            }
            char t = chars[left];
            chars[left] = chars[right];
            chars[right] = t;
            left++;
            right--;
            System.out.println(Arrays.toString(chars));
        }
        return new String(chars);
    }

    private boolean isLetter(char c) {
        if (c <= 'z' && c >= 'a') return true;
        if (c <= 'Z' && c >= 'A') return true;
        return false;
    }
}
