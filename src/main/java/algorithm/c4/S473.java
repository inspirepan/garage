package algorithm.c4;

import java.util.Arrays;

public class S473 {
    public boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;
        if (len < 4) {
            return false;
        }
        // 求总和
        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int target = sum / 4;
        // 边长
        Arrays.sort(matchsticks);
        // 从大边往下找
        int[] targets = new int[] {target, target, target, target};
        return dfs(matchsticks, len - 1, targets);
    }

    /**
     * @param matches 排序好的火柴长度
     * @param i       当前需要放入的火柴，从len-1到0
     * @param targets 需求边长数组
     * @return 是否能组成正方形
     */
    private boolean dfs(int[] matches, int i, int[] targets) {
        System.out.println(Arrays.toString(targets));
        if (i == -1) {
            return targets[3] == 0 && targets[0] == 0 && targets[1] == 0 && targets[2] == 0;
        }
        int curr = matches[i];
        for (int a = 0; a < 4; a++) {
            if (targets[a] < curr) {
                continue;
            }
            if (a > 0 && targets[a] == targets[a - 1]) {
                continue;
            }
            targets[a] -= curr;
            if (dfs(matches, i - 1, targets)) {
                return true;
            }
            targets[a] += curr;
        }
        return false;
    }
}
