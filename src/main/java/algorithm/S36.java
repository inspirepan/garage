package algorithm;

public class S36 {
    public boolean isValidSudoku(char[][] board) {
        // 行
        for (char[] row : board) {
            int[] used = new int[9];
            for (char c : row) {
                if (c != '.') {
                    if (used[c - '1'] == 1) {
                        return false;
                    }
                    used[c - '1'] = 1;
                }
            }
        }
        // 列
        for (int k = 0; k < 9; k++) {
            int[] used = new int[9];
            for (int i = 0; i < 9; i++) {
                char c;
                if ((c = board[i][k]) != '.') {
                    if (used[c - '1'] == 1) {
                        return false;
                    }
                    used[c - '1'] = 1;
                }
            }
        }
        // 小格
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] used = new int[9];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        char c = board[i + x][j + y];
                        if (c != '.') {
                            if (used[c - '1'] == 1) {
                                return false;
                            }
                            used[c - '1'] = 1;
                        }
                    }
                }
            }
        }
        return true;
    }
}
