package algorithm;

/**
 * @author : panjixiang
 * @since : 2022/11/11
 */
public class S1704 {
    class Solution {
        public boolean halvesAreAlike(String s) {
            int len = s.length();
            int count = 0;
            for (int i = 0; i < len / 2; i++) {
                if (isVowel(s.charAt(i))) {
                    ++count;
                }
            }

            for (int i = len / 2; i < len; i++) {
                if (isVowel(s.charAt(i))) {
                    --count;
                }
            }
            return count == 0;
        }

        boolean isVowel(char c) {
            return "aoeiuAOEIU".indexOf(c) != -1;
        }
    }
}