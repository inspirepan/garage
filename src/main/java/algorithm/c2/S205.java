package algorithm.c2;

import java.util.HashMap;
import java.util.HashSet;

public class S205 {
    public boolean isIsomorphic(String s, String t) {
        int len = 0;
        if ((s == null && t == null) || (s.length() == 0 && t.length() == 0)) {
            return true;
        }
        if (s == null || (len = s.length()) == 0 || t == null || t.length() == 0 || t.length() != len) {
            return false;
        }
        var map = new HashMap<Character, Character>();
        var set = new HashSet<Character>();
        var sArr = s.toCharArray();
        var tArr = t.toCharArray();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(sArr[i])) {
                if (set.contains(tArr[i])) {
                    return false;
                }
                map.put(sArr[i], tArr[i]);
                set.add(tArr[i]);
            } else {
                if (map.get(sArr[i]) != tArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
