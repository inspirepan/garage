package algorithm.c14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S1496 {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        map.put(0, set);
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'W') {
                x--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'S') {
                y--;
            }
            if (map.containsKey(x) && map.get(x).contains(y)) {
                return true;
            }
            Set<Integer> temp = map.getOrDefault(x, new HashSet<>());
            temp.add(y);
            map.put(x, temp);
        }
        return false;
    }
}
