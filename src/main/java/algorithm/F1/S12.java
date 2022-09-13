package algorithm.F1;

public class S12 {
    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, 1, -1};
    // dfs
    char[] chars;
    int m;
    int n;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        chars = word.toCharArray();
        this.board = board;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int p, int x, int y) {
        if (board[x][y] != chars[p]) {
            return false;
        }
        if (p + 1 == chars.length) {
            return true;
        }
        char t = board[x][y];
        board[x][y] = '-';
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                if (dfs(p + 1, newX, newY)) {
                    return true;
                }
            }
        }
        board[x][y] = t;

        return false;
    }
}
