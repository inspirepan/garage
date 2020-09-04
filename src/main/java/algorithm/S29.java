package algorithm;

/**
 * 两数相除
 * 边界处理太难了，倔强不想用long
 *
 * @author panjx
 */
public class S29 {
    public static void main(String[] args) {
        System.out.println(S29.divide(1100540749, -1090366779));
    }

    public static int divide(int dividend, int divisor) {
        // 特殊情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if (divisor == Integer.MIN_VALUE) return 0;
        if (divisor == 0) return 0;
        if (divisor == 1) return dividend;
        // 判断结果正负号
        boolean negative = dividend < 0 ^ divisor < 0;
        // 其中 Integer.MIN_VALUE 不能直接转成正数，够恶心
        int carry = dividend == Integer.MIN_VALUE ? 1 : 0;
        dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) return 0;
        int ans = maxPartDivide(dividend, divisor, carry);
        return negative ? -ans : ans;
    }

    public static int maxPartDivide(int dividend, int divisor, int carry) {
        if (dividend < divisor) return 0;
        int times = 1, bigDivisor = divisor;
        while (bigDivisor < Integer.MAX_VALUE - 1 - bigDivisor && bigDivisor << 1 < dividend) {
            bigDivisor <<= 1;
            times <<= 1;
        }
        return times + maxPartDivide(carry + dividend - bigDivisor, divisor, 0);
    }
}
