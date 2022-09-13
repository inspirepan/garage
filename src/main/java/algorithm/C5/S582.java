package algorithm.C5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class S582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int p : pid) {
            map.put(p, new HashSet<>());
        }
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) != 0) {
                map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        List<Integer> removed = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int remove = queue.poll();
            removed.add(remove);
            queue.addAll(map.get(remove));
        }
        return removed;
    }
}
