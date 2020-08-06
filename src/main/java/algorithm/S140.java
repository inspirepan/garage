package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.lang.StringBuilder;

public class S140 {
    private HashSet<String> wordDictSet;
    private Map<String, List<String>> map = new HashMap<>();

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
            /* 不能直接返回<=>因为即便存在于wordDict中，也可能是其他两个word的组合 */
            /*
             * map.put(s, total); return total;
             */
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);
            if (!wordDictSet.contains(sub)) {
                continue;
            }
            List<String> leftList = wordBreakHelper(s.substring(0, i));
            List<String> combinedList = new ArrayList<>();
            leftList.forEach(leftStr -> combinedList
                    .add(new StringBuilder().append(leftStr).append(" ").append(sub).toString()));
            combinedList.forEach(ss -> totalList.add(ss));
        }
        map.put(s, totalList);
        return totalList;
    }
}