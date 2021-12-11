package algorithm.S0to100;

public class S52 {

    private int count = 0;
    private int[] board;
    private int n;

    public int totalNQueens(int n) {
        this.n = n;
        this.board = new int[n];// 表示第i行中皇后的列值，不需要用二维数组了
        dfs(0);
        return count;
    }

    private void dfs(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            board[row] = col;
            if (isValid(row)) {
                dfs(row + 1);
            }
            // 不需要归位，因为循环下一次就会替换掉它
        }
    }

    private boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
