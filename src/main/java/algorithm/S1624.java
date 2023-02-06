package algorithm;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S1624 {
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int[] charMap = new int[26];
            Arrays.fill(charMap, -1);
            char[] chars = s.toCharArray();
            int res = -1;
            for (int i = 0; i < chars.length; i++) {
                int curr = chars[i] - 'a';
                if (charMap[curr] != -1) {
                    res = Math.max(res, i - charMap[curr] - 1);
                }
                if (charMap[curr] == -1) {
                    charMap[curr] = i;
                }
            }
            return res;
        }
    }
}
