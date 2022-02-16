package algorithm.C14;

import java.util.*;

public class S1451 {
    public String arrangeWords(String text) {
        // 还行，自己写的没有慢得离谱，中规中矩
        String[] words = text.split(" ");
        // 统计一遍各个长度单词的数量
        Map<Integer, Integer> lenCount = new HashMap<>();
        int maxLen = 0;
        for (var word : words) {
            int length = word.length();
            maxLen = Math.max(maxLen, length);
            lenCount.put(length, lenCount.getOrDefault(length, 0) + 1);
        }
        int count = 0;
        // 统计每个长度之前的累积量，不包括当前长度
        Map<Integer, Integer> accuCount = new HashMap<>();
        for (int i = 1; i <= maxLen; i++) {
            accuCount.put(i, count);
            count += lenCount.getOrDefault(i, 0);
        }
        // 开始顺序构建
        String[] result = new String[words.length];
        Map<Integer, Integer> finishCount = new HashMap<>();
        for (var word : words) {
            int length = word.length();
            int finish = finishCount.getOrDefault(length, 0);
            result[accuCount.get(length) + finish] = word.toLowerCase();
            finishCount.put(length, finish + 1);
        }
        String join = String.join(" ", result);
        // 首字母大写的方法
        return join.substring(0, 1).toUpperCase() + join.substring(1);
    }

    public String arrangeWords2(String text) {
        // 看了评论才知道Java的Sort其实也会保留顺序
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, Comparator.comparingInt(String::length));
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);;
        return String.join(" ", words);
    }
}
