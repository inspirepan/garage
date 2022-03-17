package algorithm.C5;

public class S562 {
    public int longestLine(int[][] mat) {
        // 四个方向检查
        int m = mat.length, n = mat[0].length;
        int max = 0;
        // 横
        for (int[] row : mat) {
            int curr = 0;
            int j = 0;
            while (j < n) {
                while (j < n && row[j] == 0) j++;
                while (j < n && row[j] == 1) {
                    j++;
                    curr++;
                }
                max = Math.max(max, curr);
                curr = 0;
            }
        }
        // 竖
        for (int j = 0; j < n; j++) {
            int curr = 0;
            int i = 0;
            while (i < m) {
                while (i < m && mat[i][j] == 0) i++;
                while (i < m && mat[i][j] == 1) {
                    i++;
                    curr++;
                }
                max = Math.max(max, curr);
                curr = 0;
            }
        }
        // 左上-右下
        for (int i = 0; i < m; i++) {
            int k = i;
            int j = 0;
            int curr = 0;
            while (k < m && j < n) {
                while (k < m && j < n && mat[k][j] == 0) {
                    k++;
                    j++;
                }
                while (k < m && j < n && mat[k][j] == 1) {
                    k++;
                    j++;
                    curr++;
                }
                max = Math.max(max, curr);
                curr = 0;
            }
        }
        for (int l = 1; l < n; l++) {
            int k = 0;
            int j = l;
            int curr = 0;
            while (k < m && j < n) {
                while (k < m && j < n && mat[k][j] == 0) {
                    k++;
                    j++;
                }
                while (k < m && j < n && mat[k][j] == 1) {
                    k++;
                    j++;
                    curr++;
                }
                max = Math.max(max, curr);
                curr = 0;
            }
        }
        // 右上-左下
        for (int i = 0; i < m; i++) {
            int j = n - 1;
            int k = i;
            int curr = 0;
            while (k < m && j >= 0) {
                while (k < m && j >= 0 && mat[k][j] == 0) {
                    k++;
                    j--;
                }
                while (k < m && j >= 0 && mat[k][j] == 1) {
                    k++;
                    j--;
                    curr++;
                }
                max = Math.max(max, curr);
                curr = 0;
            }
        }
        for (int l = n - 2; l >= 0; l--) {
            int k = 0;
            int j = l;
            int curr = 0;
            while (k < m && j >= 0) {
                while (k < m && j >= 0 && mat[k][j] == 0) {
                    k++;
                    j--;
                }
                while (k < m && j >= 0 && mat[k][j] == 1) {
                    k++;
                    j--;
                    curr++;
                }
                max = Math.max(max, curr);
                curr = 0;
            }
        }
        return max;
    }
}
