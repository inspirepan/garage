package algorithm.C2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {

            char[] pattern = s.toCharArray();
            int dist = pattern[0] - 'a';
            for (int i = 0; i < pattern.length; i++) {
                pattern[i] -= dist;
                if (pattern[i] < 'a') {
                    pattern[i] += 26;
                }
            }
            String p = new String(pattern);
            var list = map.getOrDefault(p, new ArrayList<>());
            list.add(s);
            map.put(p, list);
        }
        return new ArrayList<>(map.values());
    }
}

