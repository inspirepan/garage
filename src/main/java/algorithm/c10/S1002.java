package algorithm.c10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : panjixiang
 * @since : 2022/11/15
 */
public class S1002 {
    class Solution {
        public List<String> commonChars(String[] words) {
            int[] count = new int[26];
            Arrays.fill(count, Integer.MAX_VALUE);
            for (String word : words) {
                int[] curr = new int[26];
                for (char c : word.toCharArray()) {
                    curr[c - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    count[i] = Math.min(count[i], curr[i]);
                }
            }

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (count[i] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < count[i]; j++) {
                    ans.add(Character.toString((char) (i + 'a')));
                }
            }
            return ans;
        }
    }
}
