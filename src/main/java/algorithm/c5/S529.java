package algorithm.c5;

import java.util.ArrayList;
import java.util.List;

public class S529 {

    static final int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        int m = board.length, n = board[0].length;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        } else {
            // E
            // 原本的board只有M和E，只知道雷的位置，如果揭开了一个E，它周围八个都没有雷的话，就标记成B，然后再向四周探
            // 递归那些被标记成B的
            int mCount = 0;
            List<int[]> search = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    char c = board[nx][ny];
                    if (c == 'M') {
                        mCount++;
                    } else if (c <= '9' && c >= '1') {
                        continue;
                    } else if (c == 'B') {
                        continue;
                    } else {
                        // E 需要在标记xy之后，去递归
                        search.add(new int[]{nx, ny});
                    }
                }
            }
            if (mCount == 0) {
                board[x][y] = 'B';
                // 只有blank要递归
                for (var next : search) {
                    updateBoard(board, next);
                }
            } else {
                board[x][y] = Character.forDigit(mCount, 10);
            }
        }
        return board;
    }
}