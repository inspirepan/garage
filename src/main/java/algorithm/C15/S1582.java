package algorithm.C15;

public class S1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            int special = -1, k = 0;
            while (k < n) {
                if (mat[i][k] == 1) {
                    if (special == -1) special = k;
                    else {
                        special = -1;
                        break;
                    }
                }
                k++;
            }
            if (special != -1) {
                // 检查列
                int j = 0;
                boolean is = true;
                while (j < m) {
                    if (mat[j][special] == 1 && j != i) {
                        is = false;
                        break;
                    }
                    j++;
                }
                if (is) count++;
            }
        }
        return count;
    }
}
