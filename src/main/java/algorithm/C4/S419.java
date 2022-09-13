package algorithm.C4;

public class S419 {
    public int countBattleships(char[][] board) {
        // 统计已有的X组成的战舰数量
        // 要求使用O1的空间，那么还不能使用一个数据结构记录已经探索的X节点，还不能修改board数组？？？
        // 因为一艘战舰宽度只有1
        // 可以考虑横向扫描、纵向扫描各来一次，统计长度大于1的，最后再单独统计1*1的
        int count = 0;
        int m = board.length, n = board[0].length;
        for (char[] currRow : board) {
            int k = 0;
            while (k < n) {
                if (currRow[k] == '.') {
                    k++;
                } else {
                    int start = k;
                    while (k < n && currRow[k] == 'X') {
                        k++;
                    }
                    if (k - start > 1) {
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (k < m) {
                if (board[k][i] == '.') {
                    k++;
                } else {
                    int start = k;
                    while (k < m && board[k][i] == 'X') {
                        k++;
                    }
                    if (k - start > 1) {
                        count++;
                    }
                }
            }
        }
        // 统计孤立的1*1
        final int[] dx = new int[] {0, 0, 1, -1};
        final int[] dy = new int[] {1, -1, 0, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    boolean hasX = false;
                    for (int d = 0; d < 4; d++) {
                        int newX = i + dx[d];
                        int newY = j + dy[d];
                        if (newX >= 0 && newY >= 0 && newX < m && newY < n && board[newX][newY] == 'X') {
                            hasX = true;
                            break;
                        }
                    }
                    if (!hasX) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
