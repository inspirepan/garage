package algorithm.C8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S819 {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> map = new HashMap<>();

            int i = 0;
            while (i < paragraph.length()) {
                while (i < paragraph.length() && !isLetter(paragraph.charAt(i))) {
                    i++;
                }
                if (i == paragraph.length()) break;
                int k = i;
                while (i < paragraph.length() && isLetter(paragraph.charAt(i))) {
                    i++;
                }
                String word = paragraph.substring(k, i).toLowerCase();
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            System.out.println(map);
            Set<String> ban = new HashSet<>();
            for (String s : banned) {
                ban.add(s);
            }
            int max = 0;
            String res = "";
            for (var e : map.entrySet()) {
                if (e.getValue() > max && !ban.contains(e.getKey())) {
                    max = e.getValue();
                    res = e.getKey();
                }
            }
            return res;
        }

        boolean isLetter(char c) {
            return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        }
    }
}
