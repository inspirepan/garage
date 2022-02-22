package algorithm;

public class S647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(j) == s.charAt(i)) {
                    boolean isParlindome = i == j || j - i == 1 || dp[i + 1][j - 1];
                    dp[i][j] = isParlindome;
                    if (isParlindome) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
