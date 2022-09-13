package algorithm.C15;

public class S1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int i = 0;
        while (i <= arr.length - m * k) {
            boolean contains = true;
            OUT:
            for (int start = i; start < i + m; start++) {
                int pattern = arr[start];
                for (int j = 1; j < k; j++) {
                    if (arr[start + m * j] != pattern) {
                        contains = false;
                        break OUT;
                    }
                }
            }
            if (contains) {
                return true;
            }
            i++;
        }
        return false;
    }
}
