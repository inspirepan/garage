package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/11/15
 */
public class S999 {
    class Solution {

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        public int numRookCaptures(char[][] board) {
            int rx = 0;
            int ry = 0;
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'R') {
                        rx = i;
                        ry = j;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int x = rx;
                int y = ry;
                while (x >= 0 && y >= 0 && x < m && y < n) {
                    if (board[x][y] == 'B') {
                        break;
                    }
                    if (board[x][y] == 'p') {
                        count++;
                        break;
                    }
                    x += dx[i];
                    y += dy[i];
                }
            }
            return count;
        }
    }
}
