package algorithm.C4;

import java.util.Arrays;

public class S455 {
    public int findContentChildren(int[] g, int[] s) {
        // 排序全部的饼干和胃口
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && i + j < s.length) {
            if (g[i] > s[i + j]) {
                while (i + j < s.length && g[i] > s[i + j]) {
                    j++;
                }
            } else {
                i++;
            }
        }
        return i;
    }
}
