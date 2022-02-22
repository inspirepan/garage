package algorithm.C15;

import java.util.Collections;

public class S1539 {
    public int findKthPositive(int[] arr, int k) {
        // 正整数
        int i = 1;
        // index
        int j = 0;
        int result = 0;
        while (k > 0 && j < arr.length) {
            if (arr[j] == i) {
                i++;
                j++;
            } else if (arr[j] > i) {
                result = i++;
                k--;
            }
        }
        // 考虑arr走完了还没找到k个
        if (j == arr.length) {
            return i + k - 1;
        }
        return result;
    }
}
