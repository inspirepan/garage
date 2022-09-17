package algorithm.c9;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S948 {
    class Solution {
        public int bagOfTokensScore(int[] tokens, int power) {
            Arrays.sort(tokens);
            int left = 0;
            int right = tokens.length - 1;
            int score = 0;
            while (left <= right) {
                if (tokens[left] <= power) {
                    power -= tokens[left++];
                    score++;
                } else {
                    if (score > 0) {
                        power += tokens[right--] - tokens[left++];
                    } else {
                        return score;
                    }
                }
            }
            return score;
        }
    }
}
