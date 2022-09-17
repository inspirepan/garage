package algorithm.c9;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S935 {
    class Solution {

        public int knightDialer(int n) {
            int MOD = 1000000007;
            long[] s = new long[10];
            Arrays.fill(s, 1);
            for (int i = 1; i < n; i++) {
                long[] t = new long[10];
                t[0] = (s[4] + s[6]) % MOD;
                t[1] = (s[6] + s[8]) % MOD;
                t[2] = (s[7] + s[9]) % MOD;
                t[3] = (s[4] + s[8]) % MOD;
                t[4] = (s[0] + s[3] + s[9]) % MOD;
                t[6] = (s[0] + s[1] + s[7]) % MOD;
                t[7] = (s[2] + s[6]) % MOD;
                t[8] = (s[1] + s[3]) % MOD;
                t[9] = (s[2] + s[4]) % MOD;
                System.arraycopy(t, 0, s, 0, 10);
            }

            long res = 0;
            for (int i = 0; i < 10; i++) {
                res = (res + s[i]) % MOD;
            }
            return (int) res;
        }
    }
}
