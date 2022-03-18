package algorithm.C6;

import java.util.ArrayList;
import java.util.List;

/* 官方题解 */

public class S679 {
    static final int TARGET = 24;
    static final double ERR = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < ERR;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    // 随机选两个
                    List<Double> list2 = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            // 剩余的两个存到list中
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        /* 乘法和加法左右互换是一样的，跳过一次 */
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else {
                            /* 等于0 */
                            if (Math.abs(list.get(j)) < ERR) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (dfs(list2)) {
                            return true;
                        }
                        // 移除运算结果
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
