package algorithm.S0to100;

public class S7 {
    public int reverse(int x) {
        int p = 0;
        int ans = 0;
        while (x != 0) {
            p = x % 10;
            System.out.println(p);
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE && p > 7)) return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE && p < -8)) return 0;
            ans = 10 * ans + p;
            x = x / 10;
        }

        return ans;
    }
}
