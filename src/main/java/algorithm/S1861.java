package algorithm;

import java.util.Arrays;

public class S1861 {
    public char[][] rotateTheBox(char[][] box) {
        // 首先只需要一行一行的考虑
        // 最上面的行会变成最右边的列

        // 右边界/每个障碍物左边的石头堆在一起
        // 不是很难

        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = '.';
            }
        }
        for (int i = 0; i < m; i++) {
            char[] currRow = box[i];
            int j = 0;
            // 统计一个障碍物旁边的石头数量
            int currRock = 0;
            while (j < n) {
                if (currRow[j] == '#') {
                    currRock++;
                }
                if (currRow[j] == '*') {
                    // 填写一次result
                    result[j][m - i - 1] = '*';
                    for (int k = 1; k <= currRock; k++) {
                        result[j - k][m - i - 1] = '#';
                    }
                    currRock = 0;
                }
                j++;
            }
            for (int k = 1; k <= currRock; k++) {
                result[j - k][m - i - 1] = '#';
            }
        }
        return result;
    }
}
