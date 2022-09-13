package algorithm.c2;

import java.util.Arrays;

public class S274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        // h指数：大于h的只有h个
        int i = 1;
        for (; i < citations.length; i++) {
            if (citations[citations.length - i] < i) {
                break;
            }
        }
        return i - 1;
    }

    public int hIndex2(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= len - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}
