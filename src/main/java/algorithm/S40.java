package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S40 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            if (c > target) {
                continue;
            }
            /* 处理重复的
             移动i到最后一个重复的数处
             记录重复个数 */
            int duplicateCount = 1;
            while (i + 1 < candidates.length && candidates[i + 1] == c) {
                i++;
                duplicateCount++;
            }
            // 注意k的下标从1开始，将重复的几个数dfs全部试一遍
            for (int k = 1; k <= duplicateCount; k++) {
                if (target >= c * k) {
                    target -= c * k;
                    for (int j = 0; j < k; j++) {
                        path.addLast(c);
                    }
                    dfs(candidates, target, i + 1);
                    for (int j = 0; j < k; j++) {
                        path.removeLast();
                    }
                    target += c * k;
                }
            }
        }
    }
}
