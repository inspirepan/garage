package algorithm.c15;

public class S1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[j] - arr[i]) > a) {
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[j] - arr[k]) > b) {
                        continue;
                    }
                    if (Math.abs(arr[k] - arr[i]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
