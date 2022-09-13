package algorithm.c14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S1436 {
    public static String destCity2(List<List<String>> paths) {
        // 其实只要记录起点中没有的就行了
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (List<String> list : paths) {
            map.put(list.get(0), 1);
        }
        for (List<String> list : paths) {
            if (map.get(list.get(1)) == null) {
                return list.get(1);
            }
        }
        return null;
    }

    public String destCity(List<List<String>> paths) {
        // 自己写的，有些僵
        Map<String, Integer> map = new HashMap<>();
        for (var path : paths) {
            map.put(path.get(0), map.getOrDefault(path.get(0), 0) - 1);
            map.put(path.get(1), map.getOrDefault(path.get(1), 0) + 1);
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
