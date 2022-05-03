package algorithm.C8;

public class S812 {
    public double largestTriangleArea(int[][] points) {
        // 数学题啊
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    max = Math.max(max, area(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }

    double area(int[] a, int[] b, int[] c) {
        int x1 = b[0] - a[0];
        int y1 = b[1] - a[1];
        int x2 = c[0] - a[0];
        int y2 = c[1] - a[1];

        double t = x1 * y2 - x2 * y1;
        return t / 2;
    }
}
