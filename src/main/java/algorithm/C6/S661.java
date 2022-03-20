package algorithm.C6;

public class S661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        final int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        final int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int sum = img[x][y];
                int count = 1;
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        sum += img[nx][ny];
                        count++;
                    }
                }
                res[x][y] = sum / count;
            }
        }
        return res;
    }
}
