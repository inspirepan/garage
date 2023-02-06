package algorithm.c0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S54 {

    private final int[] right = new int[]{0, 1};
    private final int[] down = new int[]{1, 0};
    private final int[] left = new int[]{0, -1};
    private final int[] up = new int[]{-1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer> result = new ArrayList<>(height * width);
        if (height == 1) {
            for (int i : matrix[0]) {
                result.add(i);
            }
            return result;
        }
        if (width == 1) {
            for (int[] ints : matrix) {
                result.add(ints[0]);
            }
            return result;
        }
        int[] direction = right;
        int visited = 0;
        int col = 0;
        int row = 0;
        int boarder = 0;
        while (visited < height * width) {
            result.add(matrix[row][col]);
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (row == boarder + 1 && col == boarder && Arrays.equals(direction, up)) {
                boarder++;
            }
            if (Arrays.equals(direction, right) && nextCol >= width - boarder) {
                direction = down;
            } else if (Arrays.equals(direction, down) && nextRow >= height - boarder) {
                direction = left;
            } else if (Arrays.equals(direction, left) && nextCol < boarder) {
                direction = up;
            } else if (Arrays.equals(direction, up) && nextRow < boarder) {
                direction = right;
            }
            row += direction[0];
            col += direction[1];
            visited++;
        }
        return result;
    }
}