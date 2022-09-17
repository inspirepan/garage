package algorithm;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/14
 */
public class S1619 {
    class Solution {
        public double trimMean(int[] arr) {
            int len = arr.length;
            Arrays.sort(arr);
            int sum = 0;
            int start = len / 20;
            int end = len / 20 * 19;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum / (double) (end - start);
        }
    }
}
