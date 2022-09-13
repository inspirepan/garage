package algorithm.c7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class S734 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (var pair : similarPairs) {
            String a = pair.get(0);
            String b = pair.get(1);
            setPair(a, b, map);
            setPair(b, a, map);
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (!map.containsKey(sentence1[i])) {
                return false;
            }
            if (!map.get(sentence1[i]).contains(sentence2[i])) {
                return false;
            }
        }
        return true;
    }

    private void setPair(String a, String b, Map<String, Set<String>> map) {
        if (!map.containsKey(a)) {
            Set<String> setA = new HashSet<>();
            setA.add(a);
            setA.add(b);
            map.put(a, setA);
        } else {
            var setA = map.get(a);
            setA.add(b);
            map.put(a, setA);
        }
    }
}
