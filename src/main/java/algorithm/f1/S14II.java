package algorithm.f1;

public class S14II {
    public int cuttingRope(int n) {
        // 分尽可能多的3，因为大于3
        // 2->1
        // 3->3
        // 4->2*2=4
        // 只有小于4的因子是有价值的
        // 5->2*3=6 分成2和3
        // 6->3*3
        // 7->3*4
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
