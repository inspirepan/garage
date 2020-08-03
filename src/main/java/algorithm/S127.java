package algorithm;

import java.util.*;

import org.apache.commons.lang3.tuple.Pair;

public class S127 {
    /*
     * 完完全全参考的官方题解，
     * 虽然是个无向图的广度优先遍历，但是 Queue，Pair，Map这些数据结构的调用实在还是不熟练
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
        Queue<Pair<String, Integer>> queue = new LinkedList<>();

        return 0;
    }
}