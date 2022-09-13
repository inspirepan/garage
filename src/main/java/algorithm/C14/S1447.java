package algorithm.C14;

import java.util.ArrayList;
import java.util.List;

public class S1447 {
    private final List<String> result = new ArrayList<>();

    public List<String> simplifiedFractions(int n) {
        // 其实就是一个搜索，就是要忽略掉可以约分的
        helper(n);
        return result;
    }

    private void helper(int n) {
        // 只添加带有n的分数
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            if (reduced(i, n)) {
                result.add(new StringBuilder().append(i).append("/").append(n).toString());
            }
        }
        helper(n - 1);
    }

    private boolean reduced(int x, int y) {
        // 一个求最大公约数的算法
        while (true) {
            if (x > y) {
                x -= y;
            } else if (x < y) {
                y -= x;
            } else {
                return x == 1;
            }
        }
    }
}
