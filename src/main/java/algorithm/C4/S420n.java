package algorithm.C4;

public class S420n {
    // 依旧是自己写的模拟方法，比list的好了一丢丢，但是还是超时了

    public int findKthNumber(int n, int k) {
        long result = 1;
        while (--k > 0) {
            result = findNext(result, n);
        }
        return (int) result;
    }

    private long findNext(long r, int n) {
        if (r * 10 <= n) {
            return r * 10;
        }
        r += 1;
        if (r % 10 == 0) {
            while (r % 10 == 0) {
                r /= 10;
            }
            return r;
        }
        if (r > n) {
            r /= 10;
            r += 1;
            if (r % 10 == 0) {
                while (r % 10 == 0) {
                    r /= 10;
                }
            }
        }
        return r;
    }
}
