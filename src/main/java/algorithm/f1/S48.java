package algorithm.f1;

import java.util.Arrays;

public class S48 {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[1000];

        Arrays.fill(lastIndex, -1);
        int max = 0;
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastIndex[c] != -1) {
                last = Math.max(last, lastIndex[c]);
            }
            max = Math.max(max, i - last);
            lastIndex[c] = i;
        }
        return max;
    }
}
