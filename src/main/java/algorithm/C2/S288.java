package algorithm.C2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S288 {
    class ValidWordAbbr {

        Map<String, Set<String>> map = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for (String word : dictionary) {
                String abbr = getAbbr(word);
                var set = map.getOrDefault(abbr, new HashSet<>());
                set.add(word);
                map.put(abbr, set);
            }
        }

        String getAbbr(String s) {
            if (s.length() <= 2) {
                return s;
            }
            var sb = new StringBuilder();
            sb.append(s.charAt(0));
            sb.append(s.length() - 2);
            sb.append(s.charAt(s.length() - 1));
            return sb.toString();
        }

        public boolean isUnique(String word) {
            String abbr = getAbbr(word);
            if (map.containsKey(abbr)) {
                var set = map.get(abbr);
                if (set.size() >= 2) {
                    return false;
                }
                return set.contains(word);
            }
            return true;
        }
    }
}
