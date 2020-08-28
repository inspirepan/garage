package algorithm;

import java.util.Arrays;

public class S1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
        arr[0] = isOdd(arr[0]) ? 1 : 0;
        arr[1] = isOdd(arr[1]) ? (1 + arr[0]) : 0;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = isOdd(arr[i]) ? (1 + arr[i - 1]) : 0;
            if (arr[i] == 3) {
                return true;
            }
        }
        System.out.println(Arrays.toString(arr));
        return false;

    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
