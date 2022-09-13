package algorithm.c3;

public class S348 {
    class TicTacToe {

        int[][] matrix;

        public TicTacToe(int n) {
            this.matrix = new int[n][n];
        }

        public int move(int row, int col, int player) {
            if (matrix.length == 0) {
                return 0;
            }
            if (matrix[row][col] != 0) {
                return 0;
            }
            matrix[row][col] = player;
            boolean colCheck = true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][col] != player) {
                    colCheck = false;
                    break;
                }
            }
            if (colCheck) {
                return player;
            }
            boolean rowCheck = true;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[row][j] != player) {
                    rowCheck = false;
                    break;
                }
            }
            if (rowCheck) {
                return player;
            }
            if (row == col) {
                boolean crossCheck = true;
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[i][i] != player) {
                        crossCheck = false;
                        break;
                    }
                }
                if (crossCheck) {
                    return player;
                }
            }
            if (row + col == matrix.length - 1) {
                boolean crossCheck = true;
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[i][matrix.length - i - 1] != player) {
                        crossCheck = false;
                        break;
                    }
                }
                if (crossCheck) {
                    return player;
                }
            }
            return 0;
        }
    }
}
