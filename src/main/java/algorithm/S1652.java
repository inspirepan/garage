package algorithm;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/24
 */
public class S1652 {
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int len = code.length;
            int[] result = new int[len];
            if (k == 0) {
                Arrays.fill(result, 0);
                return result;
            }
            int[] sums = new int[3 * len + 1];
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < len; j++) {
                    sum += code[j];
                    sums[i * len + j + 1] = sum;
                }
            }
            if (k > 0) {
                for (int i = 0; i < len; i++) {
                    result[i] = sums[len + i + 1 + k] - sums[len + i + 1];
                }
            } else {
                for (int i = 0; i < len; i++) {
                    result[i] = sums[len + i] - sums[len + i + k];
                }
            }
            return result;
        }
    }
}
