package algorithm.c7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String result = "";
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                if (s.length() > result.length()) {
                    result = s;
                }
                set.add(s);
            }
        }
        return result;
    }
}
