package algorithm.C1;

public class S191 {
    public int hammingWeight(int n) {
        int i = Integer.SIZE;
        int count = 0;
        while (i-- != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
