package algorithm.c9;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S949 {
    class Solution {
        public String largestTimeFromDigits(int[] arr) {
            Arrays.sort(arr);
            for (int i = 3; i >= 0; i--) {
                if (arr[i] > 2) {
                    continue;
                }
                for (int j = 3; j >= 0; j--) {
                    if (j == i || arr[i] == 2 && arr[j] > 3) {
                        continue;
                    }
                    for (int k = 3; k >= 0; k--) {
                        if (k == i || k == j || arr[k] > 5) {
                            continue;
                        }
                        return "" + arr[i] + arr[j] + ':' + arr[k] + arr[6 - i - j - k];
                    }
                }
            }
            return "";
        }
    }
}
