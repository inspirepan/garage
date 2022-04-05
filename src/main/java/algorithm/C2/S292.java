package algorithm.C2;

public class S292 {
    public boolean canWinNim(int n) {
        boolean[] dp = new boolean[4];
        for (int i = 1; i <= n; i++) {
            // f(n) = !(f(n-1) && f(n-2) && f(n-3))
            // f(0) = false
            // 对于每一个选择，只有当前无论选择1-3个石子，都是必败（对面获胜）的情况下，当前n才是必败的
            // 初始0就代表必败
            boolean ret = true;
            ret &= dp[(i - 1) % 4];
            if (i >= 2) {
                ret &= dp[(i - 2) % 4];
            }
            if (i >= 3) {
                ret &= dp[(i - 3) % 4];
            }
            dp[i % 4] = !ret;
        }
        return dp[n % 4];
    }
}
