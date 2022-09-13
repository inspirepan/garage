package algorithm.c9;

public class S980 {
    private final int[] dirX = new int[] {0, 1, 0, -1};
    private final int[] dirY = new int[] {1, 0, -1, 0};
    private int count = 0;
    private int stepNeeded = 0;
    private int step = 0;
    private int startX;
    private int startY;

    public int uniquePathsIII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (grid[i][j] == 0) {
                    stepNeeded++;
                }
            }
        }
        dfs(grid, startX, startY);
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int newX = i + dirX[k];
            int newY = j + dirY[k];
            boolean checkBorder = newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length;
            if (checkBorder && grid[newX][newY] == 2 && step == stepNeeded) {
                count++;
                continue;
            }
            if (checkBorder && grid[newX][newY] == 0) {
                grid[newX][newY] = 8;
                step++;
                dfs(grid, newX, newY);
                grid[newX][newY] = 0;
                step--;
            }
        }
    }
}
