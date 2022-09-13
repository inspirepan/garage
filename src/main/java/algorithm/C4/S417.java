package algorithm.C4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S417 {
    private final int[][] direction = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 要同时能流向太平洋和大西洋
        int m = heights.length, n = heights[0].length;
        // 分别从左上角和右下角往上爬，往上逆流找可达的地方，然后看两个海洋重合的部分
        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];
        // 两个边
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            pac[i][0] = 1;
            queue.offer(new int[] {i, 0});
        }
        for (int i = 0; i < n; i++) {
            pac[0][i] = 1;
            queue.offer(new int[] {0, i});
        }
        // BFS扩张
        bfs(heights, m, n, queue, pac);
        // 处理另一个，因为此时queue已经空了，所以共用一个queue也可以
        for (int i = 0; i < m; i++) {
            atl[i][n - 1] = 1;
            queue.offer(new int[] {i, n - 1});
        }
        for (int i = 0; i < n; i++) {
            atl[m - 1][i] = 1;
            queue.offer(new int[] {m - 1, i});
        }
        bfs(heights, m, n, queue, atl);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] == 1 && atl[i][j] == 1) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, int m, int n, Deque<int[]> queue, int[][] arr) {
        while (!queue.isEmpty()) {
            int[] atlCell = queue.poll();
            int a = atlCell[0], b = atlCell[1];
            // 查看四周的节点
            for (int i = 0; i < 4; i++) {
                int newA = a + direction[i][0], newB = b + direction[i][1];
                //边界 + 没有记录过 + 高度大于等于
                if (newA >= 0 && newA < m && newB >= 0 && newB < n && arr[newA][newB] == 0 && heights[newA][newB] >= heights[a][b]) {
                    arr[newA][newB] = 1;
                    queue.offer(new int[] {newA, newB});
                }
            }
        }
    }
}

