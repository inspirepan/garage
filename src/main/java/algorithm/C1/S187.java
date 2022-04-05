package algorithm.C1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp)) {
                res.add(temp);
            }
            set.add(temp);
        }
        return new ArrayList<>(res);
    }
}