package algorithm.c14;

import java.util.Arrays;

public class S1471 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid = arr[(arr.length - 1) / 2];
        int[] result = new int[k];
        int count = 0;
        int left = 0;
        int right = arr.length - 1;
        while (count < k) {
            if (arr[right] + arr[left] > mid * 2) {
                result[count++] = arr[right--];
            } else if (arr[right] + arr[left] < mid * 2) {
                result[count++] = arr[left++];
            } else {
                result[count++] = arr[right--];
            }
        }
        return result;
    }
}
