package algorithm.C2;

public class S231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if ((n & 1) != 0) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}
