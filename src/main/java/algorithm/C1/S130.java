package algorithm.C1;

public class S130 {
    private char[][] board;
    private int rowLength;
    private int colLength;

    public void solve(char[][] board) {
        rowLength = board.length;
        if (rowLength == 0) {
            return;
        }
        colLength = board[0].length;
        if (colLength == 0) {
            return;
        }
        this.board = board;
        for (int i = 0; i < rowLength; i++) {
            findConnectedO(i, 0);
            findConnectedO(i, colLength - 1);
        }
        for (int j = 0; j < colLength; j++) {
            findConnectedO(0, j);
            findConnectedO(rowLength - 1, j);
        }
        for (int k = 0; k < rowLength; k++) {
            for (int l = 0; l < colLength; l++) {
                if (board[k][l] == 'O') {
                    board[k][l] = 'X';
                } else if (board[k][l] == 'Z') {
                    board[k][l] = 'O';
                }
            }
        }
    }

    private void findConnectedO(int i, int j) {
        if (i < 0 || j < 0 || i >= rowLength || j >= colLength || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'Z';
        findConnectedO(i - 1, j);
        findConnectedO(i + 1, j);
        findConnectedO(i, j + 1);
        findConnectedO(i, j - 1);
    }

}
