package algorithm.F1;

public class S56II {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        // ba
        // 00, 01, 10，11
        // b在a等于1的时候变位
        // a在b等于1的时候变位
        for (int n : nums) {
            a = (a ^ n) & ~b;
            b = (b ^ n) & ~a;
        }
        return a;
    }
}
