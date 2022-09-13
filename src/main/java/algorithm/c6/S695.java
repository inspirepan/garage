package algorithm.c6;

public class S695 {
    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};
    int max = 0;
    int count = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] != 1) {
                    continue;
                }
                // 开始深搜找岛屿
                dfs(x, y, grid);
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }

    private void dfs(int x, int y, int[][] grid) {
        grid[x][y] = 2;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                // 连通的新的1
                if (grid[nx][ny] == 1) {
                    dfs(nx, ny, grid);
                }
            }
        }
    }
}
