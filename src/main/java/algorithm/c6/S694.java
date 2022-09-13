package algorithm.c6;

import java.util.HashSet;
import java.util.Set;

public class S694 {
    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};

    public int numDistinctIslands(int[][] grid) {
        // 找到一个岛屿，然后序列化？用Set去比较字符串
        // BFS把找到岛屿的1全部变成2
        Set<String> result = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        int k = 2;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] != 1) {
                    continue;
                }
                // 开始深搜找岛屿
                int[] info = new int[] {x, x, y, y};
                dfs(x, y, grid, info, k);
                result.add(serialize(grid, info, k));
                k++;
            }
        }
        return result.size();
    }

    private void dfs(int x, int y, int[][] grid, int[] info, int k) {
        info[0] = Math.min(info[0], x);
        info[1] = Math.max(info[1], x);
        info[3] = Math.max(info[3], y);
        info[2] = Math.min(info[2], y);
        // 访问过了
        grid[x][y] = k;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                // 连通的新的1
                if (grid[nx][ny] == 1) {
                    dfs(nx, ny, grid, info, k);
                }
            }
        }
    }

    private String serialize(int[][] grid, int[] info, int k) {
        // 这个区域中等于k的点
        int row1 = info[0], row2 = info[1], col1 = info[2], col2 = info[3];
        var sb = new StringBuilder();
        for (int i = row1; i <= row2; i++) {
            sb.append("#");
            for (int j = col1; j <= col2; j++) {
                sb.append(grid[i][j] == k ? 1 : 0);
            }
        }
        return sb.toString();
    }
}
