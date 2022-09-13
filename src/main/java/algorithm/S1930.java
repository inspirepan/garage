package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class S1930 {
    public int countPalindromicSubsequence(String s) {
        // 完成了，但是效率很低
        // 思路其实是没问题的，就是忘记了Char可以用数组统计，不要用Hash结构统计
        HashMap<Character, List<Integer>> location = new HashMap<>();
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            List<Integer> list = location.getOrDefault(c, new ArrayList<Integer>());
            list.add(i);
            location.put(c, list);
        }
        for (Map.Entry<Character, List<Integer>> entry : location.entrySet()) {
            List<Integer> list = entry.getValue();
            int first = list.get(0);
            int last = list.get(list.size() - 1);
            char c = entry.getKey();
            for (int i = first + 1; i < last; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                sb.append(s.charAt(i));
                sb.append(c);
                result.add(sb.toString());
            }
        }
        return result.size();
    }

    public int countPalindromicSubsequence2(String s) {
        // 看的评论区的，主要一个思想还是char只有小写字符的话，不要用Map和Set统计，用数组统计
        // 再就是利用String的indexOf和lastIndexOf方法统计
        int num = 0;
        for (int i = 0; i < 26; i++) {
            int[] arr = new int[26];
            char index = (char) (i + 97);
            int left = s.indexOf(index);
            int right = s.lastIndexOf(index);
            for (int j = left + 1; j < right; j++) {
                arr[s.charAt(j) - 97]++;
            }
            for (int j = 0; j < 26; j++) {
                if (arr[j] != 0) {
                    num++;
                }
            }
        }
        return num;

    }
}
