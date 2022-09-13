package algorithm.C6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S676 {
    class MagicDictionary {

        Map<Integer, List<String>> map = new HashMap<>();

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for (String dict : dictionary) {
                var t = map.getOrDefault(dict.length(), new ArrayList<>());
                t.add(dict);
                map.put(dict.length(), t);
            }
        }

        public boolean search(String searchWord) {
            if (!map.containsKey(searchWord.length())) {
                return false;
            }
            var t = map.get(searchWord.length());
            for (String dict : t) {
                if (magic(dict, searchWord)) {
                    return true;
                }
            }
            return false;
        }

        private boolean magic(String a, String b) {
            int i = 0;
            boolean mod = false;
            while (i < a.length()) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (mod) {
                        return false;
                    }
                    mod = true;
                }
                i++;
            }
            return mod;
        }
    }
}
