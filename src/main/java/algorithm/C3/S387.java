package algorithm.C3;

import java.util.Arrays;

public class S387 {
    public int firstUniqChar(String s) {
        int len = s.length();
        int[] location = new int[26];
        Arrays.fill(location, len + 1);
        int min = len;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (location[c - 'a'] == len) continue;
            else if (location[c - 'a'] != len + 1) location[c - 'a'] = len;
            else {
                location[c - 'a'] = i;
            }
        }
        for (int d : location) {
            min = Math.min(d, min);
        }
        return min >= len ? -1 : min;
    }
}
