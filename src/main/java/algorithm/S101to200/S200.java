package algorithm.S101to200;

public class S200 {

    int[] dirX = new int[]{1, 0, -1, 0};
    int[] dirY = new int[]{0, 1, 0, -1};
    char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markConnected(i, j);
                }
            }
        }
        return count;
    }

    private void markConnected(int i, int j) {
        grid[i][j] = 'm';
        for (int k = 0; k < dirX.length; k++) {
            int newX = i + dirX[k], newY = j + dirY[k];
            boolean checkBorder = newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length;
            if (checkBorder && grid[newX][newY] == '1') {
                markConnected(newX, newY);
            }
        }
    }
}
