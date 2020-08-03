package algorithm;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class S127 {
    /*
     * 完全参考的官方题解，
     * 虽然是个无向图的广度优先遍历，但是 Queue，Pair，Map这些数据结构的调用实在不熟练
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> transform = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transform.add(word);
                allComboDict.put(newWord, transform);
            }
        });
        System.out.println(allComboDict);
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new ImmutablePair<>(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new ImmutablePair<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}