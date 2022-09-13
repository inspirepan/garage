package algorithm.C7;

import java.util.ArrayDeque;
import java.util.Deque;

public class S733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final int[] dx = new int[] {1, -1, 0, 0};
        final int[] dy = new int[] {0, 0, 1, -1};
        Deque<int[]> queue = new ArrayDeque<>();
        int originColor = image[sr][sc];
        if (newColor == originColor) {
            return image;
        }
        queue.offer(new int[] {sr, sc});
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length) {
                    if (image[nx][ny] == originColor) {
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        return image;
    }
}
