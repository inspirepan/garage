package algorithm;


public class S201 {
    public static int rangeBitwiseAnd(int m, int n) {
        int mask = 1 << 30;
        int ans = 0;
        while (mask > 0 && (m & mask) == (n & mask)) {
            ans |= m & mask;
            mask >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(19, 20));
    }

}
