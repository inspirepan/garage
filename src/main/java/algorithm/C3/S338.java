package algorithm.C3;

public class S338 {
    public int[] countBits(int n) {

        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
            // 分成奇偶考虑
                // result[i] = result[i&(i-1)] + 1;
        }
        return result;
    }
}
