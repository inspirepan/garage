package algorithm.C4;

public class S420tree {

    int n;

    public int findKthNumber(int n, int k) {
        this.n = n;
        long res = 1;
        while (k != 1) {
            long count = get(res);
            if (k <= count) {
                // 说明第k个在res这个节点后面
                res *= 10;
                k -= 1;
            } else {
                res += 1;
                k -= count;
            }
        }
        return (int) res;
    }

    public long get(long v) {
        // 算出v这个数的节点后面接了多少数
        // 1 10 100 1000
        // 1 10 100 1000
        long count = 1;
        long res = 0;
        while (v <= n) {
            res += Math.min(n - v + 1, count);
            v *= 10;
            count *= 10;
        }
        return res;
    }
}