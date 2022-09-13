package algorithm.C3;

public class S342 {
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 4) {
            return false;
        }
        while ((n & 3) == 0) {
            n >>= 2;
        }
        return n == 1;
    }
}
