package algorithm.c7;

import java.util.Arrays;

public class S787bf {
    // Bellman-Ford

    // 抄的题解
    // 不要取MAX_VALUE，不方便
    int INF = 0x3f3f3f3f;
    int[][] g;
    int[] dist;
    int n, m, src, dst, k;

    public int findCheapestPrice(int _n, int[][] flights, int _src, int _dst, int _k) {
        n = _n;
        src = _src;
        dst = _dst;
        k = _k + 1;
        g = new int[n][n];
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] f : flights) {
            g[f[0]][f[1]] = f[2];
        }
        int ans = bellman_ford();
        return ans > INF / 2 ? -1 : ans;
    }

    int bellman_ford() {
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int limit = 0; limit < k; limit++) {
            int[] clone = dist.clone();
            // 遍历全部的边 ij
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[j] = Math.min(dist[j], clone[i] + g[i][j]);
                }
            }
            System.out.println(Arrays.toString(dist));
        }
        return dist[dst];
    }
}