package algorithm.c9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S916 {
    class Solution {
        public List<String> wordSubsets(String[] words1, String[] words2) {
            int[] counts = new int[26];
            for (String s : words2) {
                count(s, counts);
            }
            List<String> res = new ArrayList<>();
            for (String s : words1) {
                if (isGeneral(s, counts)) {
                    res.add(s);
                }
            }
            return res;
        }

        private boolean isGeneral(String s, int[] counts) {
            int[] res = new int[26];
            for (char c : s.toCharArray()) {
                res[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (res[i] < counts[i]) {
                    return false;
                }
            }

            return true;
        }

        void count(String word, int[] count) {
            int[] res = new int[26];
            for (char c : word.toCharArray()) {
                res[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], res[i]);
            }
        }
    }
}
