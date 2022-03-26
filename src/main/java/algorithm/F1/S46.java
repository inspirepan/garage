package algorithm.F1;

public class S46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i] += dp[i - 1];
            int t;
            if (i > 1 && (t = Integer.parseInt(s.substring(i - 2, i))) <= 25 && t >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
