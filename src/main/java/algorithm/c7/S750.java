package algorithm.c7;

public class S750 {
    public int countCornerRectangles(int[][] grid) {
        if (grid.length == 1 || grid[0].length == 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // 感觉就是暴力啊，数据量不大，mn都小于200
        // 行扫描
        // 两行之间相同的1的数量，为k，数量 k(k-1)/2
        // 其实可以优化，跟行扫描一样，只需要dp统计列列组合的数量就可以了
        // 比如 1-3 组合出现了n次，那么1-3 组合贡献的数量就是 n(n-1)/2
        int count = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int[] t1 = grid[i];
                int[] t2 = grid[j];
                int k = 0;
                for (int l = 0; l < n; l++) {
                    if (t1[l] == 1 && t2[l] == 1) {
                        k++;
                    }
                }

                count += k * (k - 1) / 2;
            }
        }
        return count;
    }
}
