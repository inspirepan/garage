package algorithm.c3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class S332 {
    private final Deque<String> result = new ArrayDeque<>();
    private final Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.forEach(o1 -> {
            var src = o1.get(0);
            var dst = o1.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).add(dst);
        });
        dfs("JFK");
        return new ArrayList<>(result);
    }

    private void dfs(String curr) {
        System.out.println(map);
        var pq = map.get(curr);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        result.addFirst(curr);
    }
}
