package algorithm.C5;

public class S546 {

    // 一定是每次尽可能移除更多的连续同色盒子，分数会更高
    // 不好找DFS或者DP的思路啊，主要就是移除盒子之后，又会产生新的连续数组，但是也最多就产生一组

    // 怎么递推状态啊
    // 用f(l, r, k)表示移除区间[l, r]的元素、加上该区间右边等于arr[r]的k个元素组成的这个序列的最大积分
    // 真的不会

    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int length = boxes.length;
        dp = new int[length][length][length];
        return calculatePoints(boxes, 0, length - 1, 0);
    }

    public int calculatePoints(int[] boxes, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] == 0) {
            dp[l][r][k] = calculatePoints(boxes, l, r - 1, 0) + (k + 1) * (k + 1);
            for (int i = l; i < r; i++) {
                if (boxes[i] == boxes[r]) {
                    dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, l, i, k + 1) + calculatePoints(boxes, i + 1, r - 1, 0));
                }
            }
        }
        return dp[l][r][k];
    }
}