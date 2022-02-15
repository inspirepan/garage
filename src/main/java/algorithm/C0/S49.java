package algorithm.C0;

import java.util.*;

public class S49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String s2 = new String(ch);
            if (!map.containsKey(s2)) {
                map.put(s2, new ArrayList<>());
            }
            map.get(s2).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
