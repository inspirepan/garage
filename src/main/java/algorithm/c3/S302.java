package algorithm.c3;

public class S302 {

    int minX;
    int minY;
    int maxX = 0;
    int maxY = 0;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public int minArea(char[][] image, int x, int y) {
        // 本身就一个中等难度，要求是O(mn)必须用二分比较难，
        int m = image.length;
        int n = image[0].length;
        minX = m;
        minY = n;
        dfs(image, x, y);
        return (maxY - minY + 1) * (maxX - minX + 1);
    }

    void dfs(char[][] image, int x, int y) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (image[x][y] != '1') {
            return;
        }
        image[x][y] = '2';
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        maxX = Math.max(maxX, x);

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            dfs(image, nx, ny);
        }
    }
}
