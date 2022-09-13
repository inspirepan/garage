package algorithm.C7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class S743pq {
    // 抄的
    Map<Integer, Map<Integer, Integer>> connect;

    public int networkDelayTime(int[][] times, int n, int k) {
        connect = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int source = times[i][0], dest = times[i][1], time = times[i][2];
            Map cur = connect.getOrDefault(source, new HashMap<Integer, Integer>());
            cur.put(dest, time);
            connect.put(source, cur);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        pq.add(new int[] {0, k});
        Set<Integer> satisfied = new HashSet<>();
        while (pq.size() > 0) {
            // 取出当前距离最小的
            int[] cur = pq.poll();
            int time = cur[0], node = cur[1];
            if (satisfied.contains(node)) {
                continue;
            }
            satisfied.add(node);
            // 当全部的节点都满足了，为什么这里可以用==n，万一有孤立节点呢
            if (satisfied.size() == n) {
                return time;
            }
            if (connect.containsKey(node)) {
                // 如果存在边
                for (int other : connect.get(node).keySet()) {
                    if (!satisfied.contains(other)) {
                        // 对于没有满足
                        int tm = connect.get(node).get(other);
                        pq.add(new int[] {time + tm, other});
                    }
                }
            }
        }
        return -1;
    }
}
