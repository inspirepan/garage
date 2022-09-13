package algorithm.c14;

public class S1492 {
    public int kthFactor(int n, int k) {
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }

        int i = 2;
        int count = 1;
        while (i < (n / 2 + 1)) {
            if (n % i == 0) {
                if (++count == k) {
                    return i;
                }
            }
            i++;
        }
        return k == count + 1 ? n : -1;
    }
}
