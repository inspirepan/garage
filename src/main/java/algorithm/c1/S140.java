package algorithm.c1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class S140 {
    private final Map<String, List<String>> map = new HashMap<>();
    private HashSet<String> wordDictSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDictSet = new HashSet<>(wordDict);
        return wordBreakHelper(s);
    }

    private List<String> wordBreakHelper(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> totalList = new ArrayList<>();
        if (wordDictSet.contains(s)) {
            totalList.add(s);
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);
            if (!wordDictSet.contains(sub)) {
                continue;
            }
            List<String> leftList = wordBreakHelper(s.substring(0, i));
            List<String> combinedList = new ArrayList<>();
            leftList.forEach(leftStr -> combinedList.add(leftStr + " " + sub));
            totalList.addAll(combinedList);
        }
        map.put(s, totalList);
        return totalList;
    }
}