package algorithm.C4;

public class S403 {
    public boolean canCross(int[] stones) {
        int len = stones.length;

        //dp[i][j] 表示 第 i 个石头是否可以跳 j 步
        // 很重要的条件是步数是有上限的，因为每次只能往前跳，所以最多跳len-1次，步数最多增长为len，因此可以确定上界为len，数组大小为len+1
        boolean[][] dp = new boolean[len][len + 1];

        //初始条件：第 0 个石头可以跳 1 步
        dp[0][1] = true;

        for (int i = 1; i < len; i++) {
            boolean flag = false;
            //因为 石头 i 最大只能跳 i + 1 步，因此 前面的石头 j 到达 石头 i 的距离必须 <= i
            for (int j = i - 1; j >= 0; j--) {
                int diff = stones[i] - stones[j];
                // 为什么可以这样子剪枝呢
                if (diff > i) {
                    break;
                }
                //对于 石头 j ，它需要跳 diff 步
                if (dp[j][diff]) {
                    dp[i][diff - 1] = true;
                    dp[i][diff] = true;
                    dp[i][diff + 1] = true;
                    flag = true;
                }
            }
            if (i == len - 1 && !flag) {
                return false;
            }
        }
        return true;
    }
}
