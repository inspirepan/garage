package algorithm.C4;

import java.util.HashMap;
import java.util.Map;

public class S464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 在有n个数可以自己选择的时候，可以是用n长度的二进制数来表示状态！010101分别表示选取不选取状态
        if (desiredTotal <= maxChoosableInteger) return true;
        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) return false;
        Boolean[] dp = new Boolean[(1 << maxChoosableInteger) - 1];
        return dfs(maxChoosableInteger, desiredTotal, 0, dp);
    }

    private boolean dfs(int maxChoosableInteger, int desiredTotal, int state, Boolean[] dp) {
        if (dp[state] != null) {
            return dp[state];
        }
        for (int i = maxChoosableInteger; i > 0; --i) {
            // 被取过了
            if ((state & (1 << (i - 1))) != 0) continue;
            // 新状态
            int newState = (state | (1 << (i - 1)));
            // 如果选择的数大于目标 或者 目标-选择的数在当前状态下不能稳赢，就赢了
            if (i - desiredTotal >= 0 || !dfs(maxChoosableInteger, desiredTotal - i, newState, dp)) {
                dp[state] = true;
                return true;
            }
        }
        dp[state] = false;
        return false;
    }
}
