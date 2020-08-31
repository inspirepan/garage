package algorithm;

import java.util.ArrayList;
import java.util.List;

public class S51 {
    private List<List<String>> result = new ArrayList<>();
    private char[][] solution;
    private int n;

    public List<List<String>> solveNqueens(int n) {
        this.n = n;
        solution = new char[n][n];
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                solution[i][j] = '.';
            }
        }
        solveNQueensHelper(0);
        return result;
    }

    private void solveNQueensHelper(int row) {
        if (row == n) {
            var solutionList = new ArrayList<String>();
            for (var line : solution) {
                solutionList.add(String.valueOf(line));
            }
            result.add(solutionList);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                var sb = new StringBuilder();
                solution[row][col] = 'Q';
                solveNQueensHelper(row + 1);
                solution[row][col] = '.';
            }
        }

    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (solution[i][col] == 'Q'
                    || (col - row + i >= 0 && solution[i][col - row + i] == 'Q')
                    || (col + row - i < n && solution[i][col + row - i] == 'Q')) {
                return false;
            }
        }
        return true;
    }
}
