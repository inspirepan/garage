package algorithm.F2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class S05 {
    public int maxProduct(String[] words) {
        // 做得复杂了，实际上可以用一个26位的二进制数记录的，然后比较是否重复就用相与是否大于1
        if (words.length < 2) return 0;
        Map<String, int[]> map = new HashMap<>();
        for (String word : words) {
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
            map.put(word, count);
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];

            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                if (check(word1, word2, map)) {
                    max = Math.max(max, word1.length() * word2.length());
                }
            }
        }
        return max;
    }

    private boolean check(String word1, String word2, Map<String, int[]> map) {
        int[] c1 = map.get(word1);
        int[] c2 = map.get(word2);
        for (int i = 0; i < 26; i++) {
            if (c1[i] > 0 && c2[i] > 0) return false;
        }
        return true;
    }
}
