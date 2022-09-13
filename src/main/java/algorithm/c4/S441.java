package algorithm.c4;

public class S441 {
    public int arrangeCoins(int n) {
        int k = 1;
        while (n > k) {
            n -= k++;
        }
        return k - 1;
    }
}
