package algorithm.C0;

/**
 * 回溯超时了，用dp
 * 坑点是注意0的处理
 */
public class S91 {

    public int numDecodings2(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > '0') {
                dp[i + 1] = dp[i];
            }
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        // 如果是0就不行
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        if (len == 1) {
            return dp[0];
        }
        if (s.charAt(0) == '0' || (s.charAt(1) == '0' && s.charAt(0) != '1' && s.charAt(0) != '2')) {
            return 0;
        }
        int v2 = Integer.parseInt(s.substring(0, 2));
        if ((v2 > 10 && v2 < 20) || (v2 > 20 && v2 <= 26)) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < len; i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                return 0;
            }
            int val = Integer.parseInt(s.substring(i - 1, i + 1));

            if ((val > 10 && val < 20) || (val > 20 && val <= 26)) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (val == 10 || val == 20) {
                dp[i] = dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}
