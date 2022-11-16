package algorithm.c10;

public class S1089 {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int i = 0;
        int z = 0;

        while (i < len) {
            if (arr[i] == 0) {
                z++;
            }
            if (i + z >= len - 1) {
                break;
            }
            i++;
        }
        int k = i + z;
        int j = i;
        while (k >= 0) {
            if (arr[j] == 0) {
                if (k < len) {
                    arr[k] = 0;
                }
                if (--k < len) {
                    arr[k] = 0;
                }
            } else {
                arr[k] = arr[j];
            }
            k--;
            j--;
        }
    }
}
