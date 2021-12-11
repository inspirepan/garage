package algorithm.S101to200;

public class S190 {
    public static int reverseBits(int n) {
//        return Integer.reverse(n);
        int size = Integer.SIZE;
        int ans = 0;
        // 原数从低往高读取，新数从高往低生成
        while (size-- != 0) {
            ans <<= 1;
            int digit = n & 1;
            ans += digit;
            n >>= 1;
        }
        return ans;
    }
}
