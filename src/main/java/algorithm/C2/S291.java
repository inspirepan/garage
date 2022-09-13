package algorithm.C2;

import java.util.HashMap;
import java.util.Map;

public class S291 {
    Map<Character, String> map1 = new HashMap<>();
    Map<String, Character> map2 = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String s) {
        char[] parr = pattern.toCharArray();
        char[] sarr = s.toCharArray();
        return helper(0, 0, parr, sarr);
        // 思路就是从第一个p字符、第一个长度1的s子串开始试，试到全部的可能情况

    }

    boolean helper(int i, int j, char[] parr, char[] sarr) {

        if (i == parr.length && j == sarr.length) {
            return true;
        }
        if (i >= parr.length && j < sarr.length) {
            return false;
        }
        if (i < parr.length && j >= sarr.length) {
            return false;
        }

        if (map1.containsKey(parr[i])) {
            String t = map1.get(parr[i]);
            if (j + t.length() > sarr.length) {
                return false;
            }
            if (substring(sarr, j, j + t.length()).equals(t)) {
                return helper(i + 1, j + t.length(), parr, sarr);
            }
            return false;
        } else {
            for (int k = j + 1; k <= sarr.length; k++) {
                String t = substring(sarr, j, k);
                if (map2.containsKey(t)) {
                    continue;
                }
                map1.put(parr[i], t);
                map2.put(t, parr[i]);
                if (helper(i + 1, k, parr, sarr)) {
                    return true;
                } else {
                    map2.remove(t);
                    map1.remove(parr[i]);
                }
            }
        }
        return false;
    }

    String substring(char[] arr, int s, int e) {
        StringBuilder sb = new StringBuilder();
        while (s < e) {
            sb.append(arr[s++]);
        }
        return sb.toString();
    }
}
