package algorithm.c15;

public class S1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        int i = 0;
        while (i < len - 2) {
            if ((arr[i] & 1) == 1 && (arr[i + 1] & 1) == 1 && (arr[i + 2] & 1) == 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}
