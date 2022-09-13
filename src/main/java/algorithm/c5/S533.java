package algorithm.c5;

import java.util.HashMap;
import java.util.Map;

public class S533 {
    // 某行某列要求target个，还是一样的方法，统计满足要求的行，记录这一行的全部B所在的列，然后再按列找
    // 题目太辣鸡了，懒得做了，复制的评论的做法，有点浪费了
    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length;
        int n = picture[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
            String rowString = new String(picture[i]);
            map.put(rowString, map.getOrDefault(rowString, 0) + 1);
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            int times = map.get(new String(picture[i]));
            if (times != target) {
                continue;
            }
            // 每一列
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == target && colCount[j] == target) {
                    result++;
                }
            }
        }
        return result;
    }
}