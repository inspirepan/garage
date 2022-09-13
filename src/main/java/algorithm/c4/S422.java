package algorithm.c4;

import java.util.List;

public class S422 {
    public boolean validWordSquare(List<String> words) {
        // 为毛字符串的简单题感觉都不简单啊
        int m = words.size();
        int n = words.get(0).length();
        if (m != n) {
            return false;
        }
        char[][] cmap = new char[m][n];
        int index = 0;
        for (String word : words) {
            // 转移到cmap中
            // 不能超出这个框架
            if (word.length() > m) {
                return false;
            }
            System.arraycopy(word.toCharArray(), 0, cmap[index++], 0, word.length());
        }

        for (int i = 0; i < m; i++) {
            // 第i行与第i列匹配
            int k = 0;
            while (k < m) {
                if (cmap[k][i] != cmap[i][k]) {
                    return false;
                }
                k++;
            }
        }
        return true;
    }
}
