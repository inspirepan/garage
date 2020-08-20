package algorithm;

public class S529 {
    int[] dirX = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
    int[] dirY = new int[]{1, 0, -1, 1, -1, 1, 0, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            updateBoardHelper(board, row, col);
        }
        return board;
    }

    private void updateBoardHelper(char[][] board, int row, int col) {
        if (board[row][col] == 'M') {
            return;
        } else if (board[row][col] == 'B') {
            return;
        } else if (board[row][col] >= '1' && board[row][col] <= '9') {
            return;
        }
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = row + dirX[i];
            int newY = col + dirY[i];
            if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && board[newX][newY] == 'M') {
                count++;
            }
        }
        if (count != 0) {
            board[row][col] = (char) (count + '0');
        } else {
            board[row][col] = 'B';
            for (int i = 0; i < 8; i++) {
                int newX = row + dirX[i];
                int newY = col + dirY[i];
                if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && board[newX][newY] == 'E') {
                    updateBoardHelper(board, newX, newY);
                }
            }
        }
    }
}
