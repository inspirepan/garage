package algorithm.C6;

public class S693 {
    public boolean hasAlternatingBits(int n) {
        int curr = n & 1;
        while (n > 0) {
            if ((n & 1) != curr) return false;
            n >>>= 1;
            curr = (curr == 1) ? 0 : 1;
        }
        return true;
    }
}
