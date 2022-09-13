package algorithm.C15;

public class S1551 {
    public int minOperations(int n) {
        if (n <= 1) {
            return 0;
        }
        if ((n & 1) == 0) {
            // 1 3 5 7 1+3 1+3+5
            return n * n / 4;
        } else {
            // 1 3 5 7 9   (2+4)
            // 7: (2+4+6)
            return (1 + n) * (n / 2) / 2;
        }
    }
}
