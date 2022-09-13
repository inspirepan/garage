package algorithm.c5;

public class S531 {
    public int findLonelyPixel(char[][] picture) {
        // 分别统计行列，如果存在两个以上的黑色像素，标记成-1，否则记录单个像素的列/行，再对比行列数据
        int m = picture.length;
        int n = picture[0].length;
        int[] countRow = new int[m];
        int single = 0;
        for (int i = 0; i < m; i++) {
            int count = 0;
            countRow[i] = -1;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    if (++count > 1) {
                        countRow[i] = -1;
                        break;
                    } else {
                        countRow[i] = j;
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 0;
            int singleRow = -1;
            for (int i = 0; i < m; i++) {
                if (picture[i][j] == 'B') {
                    if (++count > 1) {
                        break;
                    } else {
                        singleRow = i;
                    }
                }
            }
            if (count == 1 && countRow[singleRow] == j) {
                single++;
            }
        }
        return single;
    }
}
