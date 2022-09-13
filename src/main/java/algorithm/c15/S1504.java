package algorithm.c15;

public class S1504 {
    public int numSubmat(int[][] mat) {
        // 想起85题的做法了
        int count = 0;
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                // 统计累加的1
                if (mat[i][j] != 0) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }
        // 一层层遍历，必须要用到当前层的
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                count += mat[i][j]; // 用到这一层的1，单列，高度为n，那就代表1*1，1*2，...，1*n大小的矩形
                // 考虑列和列之间的组成的矩形
                // 必须用到当前列、当前行的1，那么也就是说高度和宽度决定了数量
                // 往前遍历直到边界或者当前行的0
                // 1 3 2 0
                // 当前在2这里，那么往前遍历就是 3处：2*1，2*2，1处：3*1，数量等于最小值
                if (mat[i][j] != 0) {
                    int k = j - 1;
                    int currMin = mat[i][j];
                    while (k >= 0 && mat[i][k] != 0) {
                        currMin = Math.min(currMin, mat[i][k]);
                        count += currMin;
                        k--;
                    }
                }
            }
            System.out.println(count);
        }
        return count;
    }
}

//        1 0 1 1 1 1 1
//        2 1 0 0 0 2 2
//        3 2 1 0 0 3 3
//        4 0 2 0 1 0 4
//        5 0*3*1*2 0 5
//        16 + 1 1