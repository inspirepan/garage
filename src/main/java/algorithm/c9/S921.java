package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S921 {
    class Solution {
        public int minAddToMakeValid(String s) {
            int left = 0;
            int right = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    right++;
                } else {
                    if (right != 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return left + right;
        }
    }
}
