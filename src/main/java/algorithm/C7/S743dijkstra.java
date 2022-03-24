package algorithm.C7;

import java.util.*;

public class S743dijkstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        // distances to all node of node k, return the max of distance
        // Dijkstra
        // ignore node 0
        int[] distance = new int[n + 1];
        int[] satisfied = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[k] = 0;
        satisfied[k] = 1;
        // source node, [destination node, path length]
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int pathLen = time[2];
            var list = map.getOrDefault(source, new ArrayList<>());
            list.add(new Integer[]{dest, pathLen});
            map.put(source, list);
        }
        while (true) {
            // satisfied中已经确定了最短的距离，需要根据map，算出当前satisfied节点下一级的全部距离，取一个最短的，作为下一个加入satisfied的节点
            int min = Integer.MAX_VALUE;
            int minDest = 1;
            int nextCount = 0;
            for (int i = 1; i <= n; i++) {
                if (satisfied[i] == 0) continue;
                // 每一个已经最短的节点
                if (!map.containsKey(i)) continue;
                var nextNodeList = map.get(i);
                for (Integer[] next : nextNodeList) {
                    // 往下的下一个节点
                    int dest = next[0];
                    int time = next[1];
                    if (satisfied[dest] == 1) continue;
                    nextCount++;
                    if (distance[dest] == -1) {
                        distance[dest] = distance[i] + time;
                    } else {
                        distance[dest] = Math.min(distance[dest], distance[i] + time);
                    }
                    if (distance[dest] < min) {
                        min = distance[dest];
                        minDest = dest;
                    }
                }
            }
            if (nextCount == 0) break;
            // 选出最近的加入satisfied
            satisfied[minDest] = 1;
            // 还有没有可以加入的新节点
            // 减去已经加入的节点
            nextCount -= 1;
            if (map.containsKey(minDest)) {
                var list = map.get(minDest);
                for (Integer[] next : list) {
                    if (satisfied[next[0]] == 0) nextCount++;
                }
            }
            if (nextCount == 0) break;
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == -1) return -1;
            max = Math.max(distance[i], max);
        }
        return max;
    }
}
