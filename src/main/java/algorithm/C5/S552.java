package algorithm.C5;

public class S552 {
    public int checkRecord(int n) {
        // 1个或者0个A
        // 不允许三个连续的L
        // dp：n表示n可能的记录？
        // dp分成含有A和没有A的两组
        // 怎么排除连续三L呢
        // dp的第二位表示有连续几个L
        /** dp：
         1、分析状态
         共有6个合格状态：P、L、LL、A、AL、ALL，其中A表示旷课情况，L表示结尾的连续迟到情况，P表示无旷课且前一天未迟到；
         2、对每个状态分析转移路径：
         P    :+P->P、+L->L、+A->A;
         L    :+P->P、+L->LL、+A->A;
         LL    :+P->P、+L->不合格、+A->A;
         A    :+P->A、+L->AL、+A->不合格;
         AL    :+P->A、+L->LL、+A->不合格;
         ALL    :+P->A、+L->不合格、+A->不合格;
         3、根据转移路径，分析每个状态可能的前一步状态
         P：P+L+LL
         L：P
         LL：L
         A：P+L+LL+A+AL+ALL
         AL：A
         ALL：AL
         4、写成代码
         构建dp[i][j][k]，记录每一步可能的状态的个数，i表示步数，j表示A的个数，k表示最近连续的L个数（可优化为二维数组）*/
        long dp[][][] = new long[n][2][3];
        int M = 1000000007;
        dp[0][0][0] = 1; // P
        dp[0][0][1] = 1; // L
        dp[0][1][0] = 1; // A
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % M; // P = P/PL/PL + P
            dp[i][0][1] = dp[i - 1][0][0]; // L = P + L
            dp[i][0][2] = dp[i - 1][0][1]; // LL = L + L
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % M;
            // A = (P/PL/PLL + A) / (A/AL/ALL + P)
            dp[i][1][1] = dp[i - 1][1][0]; // AL = A + L
            dp[i][1][2] = dp[i - 1][1][1]; // ALL = AL + L
        }
        int sum = 0;
        // n-1天的情况
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sum += dp[n - 1][i][j];
                sum %= M;
            }
        }
        return sum;
    }
}
