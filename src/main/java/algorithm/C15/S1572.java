package algorithm.C15;

public class S1572 {
    public int diagonalSum(int[][] mat) {
        int count = 0, index, m = mat.length;
        for (int i = 0; i < m; i++) count += mat[i][i] + mat[i][m - i - 1];
        if ((m & 1) == 1) count -= mat[index = m >> 1][index];
        return count;
    }
}
