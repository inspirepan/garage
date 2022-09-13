package algorithm.C0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 这里用的是排序之后的字符串作为key，也可以用质数相乘的方法作为key，设置26个字母对应的质数，用long类型，根据频率相乘作为key
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
