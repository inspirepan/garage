package algorithm.c7;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class S787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Dijkstra
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (var flight : flights) {
            if (!map.containsKey(flight[0])) {
                Map<Integer, Integer> to = new HashMap<>();
                to.put(flight[1], flight[2]);
                map.put(flight[0], to);
            } else {
                map.get(flight[0]).put(flight[1], flight[2]);
            }
        }
        if (!map.containsKey(src)) {
            return -1;
        }
        int step = 0;
        Map<Integer, Integer> currMin = new HashMap<>();
        currMin.put(src, 0);
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int currStep = 1;
        while (!queue.isEmpty() && step <= k) {
            int nextStep = 0;
            for (int i = 0; i < currStep; i++) {
                int[] curr = queue.poll();
                int from = curr[0], currPrice = curr[1];
                if (map.containsKey(from)) {
                    var toMap = map.get(from);
                    for (var entry : toMap.entrySet()) {
                        int price = currPrice + entry.getValue(), to = entry.getKey();
                        if (currMin.containsKey(to) && currMin.get(to) < price) {
                            continue;
                        }
                        currMin.put(to, price);
                        queue.offer(new int[]{to, price});
                        nextStep++;
                    }
                }
            }
            currStep = nextStep;
            step++;
        }
        return currMin.getOrDefault(dst, -1);
    }
}
