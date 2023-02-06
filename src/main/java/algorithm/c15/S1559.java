package algorithm.c15;

public class S1559 {
    private final int[][] nexts = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public boolean containsCycle(char[][] grid) {
        // 维护一个visited结构保存已经访问过的节点
        // 因为是环结构，那么在一个环中的任何一个节点都可以访问到全部环中的节点
        // 那么遍历grid中的每一节点，如果之前访问过就不要管了，
        // 每次从一个节点出发，广度搜索，不需要保存路径长度，如果访问到了之前的节点，那么就存在环

        int m = grid.length;
        if (m <= 1) {
            return false;
        }
        int n = grid[0].length;
        if (n <= 1) {
            return false;
        }

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    // 如果访问过
                    continue;
                }
                if (search(grid, visited, i, j, -2, -2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] grid, boolean[][] visited, int i, int j, int fromI, int fromJ) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        boolean[] ok = new boolean[4];
        // 先看一圈周围的
        for (int k = 0; k < 4; k++) {
            int nextI = i + nexts[k][0];
            int nextJ = j + nexts[k][1];
            if (nextI == fromI && nextJ == fromJ) {
                continue;
            }
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                if (grid[i][j] == grid[nextI][nextJ]) {
                    if (visited[nextI][nextJ]) {
                        return true;
                    }
                    ok[k] = true;
                }
            }
        }
        // 根据之前记录的可选方向，往下搜
        for (int k = 0; k < 4; k++) {
            if (ok[k]) {
                if (search(grid, visited, i + nexts[k][0], j + nexts[k][1], i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
