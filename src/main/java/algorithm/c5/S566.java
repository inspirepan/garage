package algorithm.c5;

public class S566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // 不合理还要输出原始矩阵
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] newMat = new int[r][c];
        int index = 0;
        while (index < m * n) {
            newMat[index / c][index % c] = mat[index / n][index % n];
            index++;
        }
        return newMat;
    }
}
