package algorithm.C2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class S286 {

    public void wallsAndGates(int[][] rooms) {
        // 先把全部的门放入第一层bfsQueue里面就好了
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int distance = 1;
        int curr = queue.size();
        while (!queue.isEmpty()) {
            int next = 0;
            for (int i = 0; i < curr; i++) {
                int[] xy = queue.poll();
                int x = xy[0], y = xy[1];
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && rooms[nx][ny] == Integer.MAX_VALUE) {
                        next++;
                        rooms[nx][ny] = distance;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            curr = next;
            distance++;
        }
    }
}
