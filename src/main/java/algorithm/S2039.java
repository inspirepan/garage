package algorithm;

import java.util.*;

public class S2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        // 先计算每个服务器到主服务器的最短距离 dist
        // 每个服务器对应的消息传输完毕的时间是：
        // if patience>2*dist then 2dist
        // else 2dist + lastSend
        // 最后一次发送消息的时间是 ((2dist-1)/patience)*patience
        int n = patience.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        // 邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (var edge : edges) {
            int a = edge[0], b = edge[1];
            var al = map.getOrDefault(a, new ArrayList<>());
            var bl = map.getOrDefault(b, new ArrayList<>());
            al.add(b);
            bl.add(a);
            map.put(a, al);
            map.put(b, bl);
        }
        // 广度优先搜索和0的距离
        // 因为没有负权值，所以一层层往外找、第一次找到最短距离
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int distance = 0;
        int count = 1;
        while (count > 0 && !queue.isEmpty()) {
            int nextCount = 0;
            ++distance;
            for (int i = 0; i < count; i++) {
                int curr = queue.poll();
                for (int neighbor : map.get(curr)) {
                    if (dist[neighbor] == -1) {
                        dist[neighbor] = distance;
                        nextCount++;
                        queue.offer(neighbor);
                    }
                }
            }
            count = nextCount;
        }
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            int p = patience[i], d = dist[i];
            if (p >= 2 * d) maxTime = Math.max(maxTime, 2 * d);
            else {
                int time = 2 * d + (2 * d - 1) / p * p;
                maxTime = Math.max(maxTime, time);
            }
        }
        return maxTime + 1;
    }
}
