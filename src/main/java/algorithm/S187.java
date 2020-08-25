package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S187 {
    public List<String> findRepeatedDnaSequences(String s) {
        var resultSet = new HashSet<String>();
        var set = new HashSet<String>();
        for (int i = 0; i <= s.length() - 10; i++) {
            var sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                resultSet.add(sub);
            } else {
                set.add(sub);
            }
        }
        return new ArrayList<>(resultSet);
    }

}
