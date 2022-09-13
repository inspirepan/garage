package algorithm.F1;

public class S29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;
        final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, -0}}; // 右 下 左 上
        int dir = 0; // 向右开始
        int x = 0;
        int y = 0;
        int boarder = 0;
        while (index < m * n) {
            result[index++] = matrix[x][y];
            // 更新下一个坐标
            if (index == m * n) {
                break;
            }
            if (dir == 3 && x == boarder + 1 && y == boarder) {
                // 当向上转到这一圈的左上角
                boarder++;
            }
            while (true) {
                int nX = x + directions[dir][0];
                int nY = y + directions[dir][1];
                if (nX >= boarder && nX < m - boarder && nY >= boarder && nY < n - boarder) {
                    x = nX;
                    y = nY;
                    break;
                }
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir++;
                }
            }
        }
        return result;
    }
}
