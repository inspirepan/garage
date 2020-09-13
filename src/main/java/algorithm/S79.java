package algorithm;

public class S79 {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int height = board.length;
        int width = board[0].length;
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int start) {
        if (start == word.length()) {
            return true;
        }
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            if (!visited[row][col] && board[row][col] == word.charAt(start)) {
                visited[row][col] = true;
                if (dfs(board, word, row + 1, col, start + 1)) {
                    return true;
                } else if (dfs(board, word, row - 1, col, start + 1)) {
                    return true;
                } else if (dfs(board, word, row, col + 1, start + 1)) {
                    return true;
                } else if (dfs(board, word, row, col - 1, start + 1)) {
                    return true;
                }
                visited[row][col] = false;
            }
        }
        return false;
    }
}
