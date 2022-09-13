package algorithm.c0;

public class S85 {
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0) {
            return 0;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return 0;
        }
        int[] h = new int[width];
        int max = 0;
        for (char[] line : matrix) {
            for (int i = 0; i < width; i++) {
                if (line[i] == '0') {
                    h[i] = 0;
                } else {
                    h[i]++;
                }
            }
            max = Math.max(max, largestRectangleArea(h));
        }
        return max;
    }

    public int largestRectangleArea(int[] h) {
        int len = h.length;
        if (len == 0) {
            return 0;
        }
        // the first left less one of curr index
        int[] left = new int[len];
        // the first right less one of curr index
        int[] right = new int[len];
        left[0] = -1;
        right[len - 1] = len;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            while (j >= 0 && h[j] >= h[i]) {
                j = left[j];
            }
            left[i] = j;
        }
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < len && h[j] >= h[i]) {
                j = right[j];
            }
            right[i] = j;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, h[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
