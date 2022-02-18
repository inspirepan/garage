package algorithm.C15;

import java.util.Arrays;

public class S1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        Arrays.sort(arr);
        int i = 2;
        int distance = arr[1] - arr[0];
        while (i < arr.length) {
            if (arr[i] - arr[i - 1] != distance) {
                return false;
            }
            i++;
        }
        return true;
    }
}
