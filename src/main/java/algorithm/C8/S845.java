package algorithm.C8;

public class S845 {

    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int start = 0;
        int prev = A[0];
        int max = 0;
        boolean up = true;
        for (int i = 1; i < A.length; i++) {
            int curr = A[i];
            // 上升
            if (up) {
                if (curr == prev) {
                    start = i;
                } else if (curr < prev) {
                    if (i != start + 1) {
                        up = false;
                        max = Math.max(max, i - start + 1);
                    } else {
                        start = i;
                    }
                }
            }
            // 下降
            else {
                if (curr < prev) {
                    max = Math.max(max, i - start + 1);
                } else if (curr == prev) {
                    start = i;
                    up = true;
                } else {
                    start = i - 1;
                    up = true;
                }
            }
            prev = curr;
        }
        return max;
    }
}
