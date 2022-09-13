package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 211 这题其实实现难度不大，只是直接将查询的词和字典所有的词比较会超时。因此用了长度来分类
 */
public class WordDictionary {
    Map<Integer, Set<String>> map = new HashMap<>();

    public WordDictionary() {

    }

    public void addWord(String word) {
        int len = word.length();
        var set = map.getOrDefault(len, new HashSet<>());
        set.add(word);
        map.put(len, set);
    }

    public boolean search(String word) {
        int len = word.length();
        if (!map.containsKey(len)) {
            return false;
        }
        for (String w : map.get(len)) {
            if (match(word, w)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(String word, String w) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                continue;
            }
            if (word.charAt(i) != w.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
