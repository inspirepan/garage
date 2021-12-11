package algorithm.S0to100;

public class S85 {
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0) return 0;
        int width = matrix[0].length;
        if (width == 0) return 0;
        int[] heights = new int[width];
        int max = 0;
        for (char[] line : matrix) {
            for (int i = 0; i < width; i++) {
                if (line[i] == '0') heights[i] = 0;
                else heights[i]++;
            }
            max = Math.max(max, largestRectangleArea3(heights));
        }
        return max;
    }

    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        // the first left less one of curr index
        int[] left = new int[n];
        // the first right less one of curr index
        int[] right = new int[n];
        left[0] = -1;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) j = left[j];
            left[i] = j;
        }
        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) j = right[j];
            right[i] = j;
        }
        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        return res;
    }
}
