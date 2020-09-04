package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联字符串在主字符串中出现的索引
 */
public class S30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordsCount = words.length;
        if (wordsCount == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int totalLen = wordLen * wordsCount;
        // 保存每个单词出现的次数
        var dict = new HashMap<String, Integer>();
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        // 把整个字符串分成wordLen长度多个连续子串，那么有从0到wordLen-1种情况
        for (int j = 0; j < wordLen; j++) {
            // 每种情况记录一个map，记录dict中有的单词出现的次数
            var map = new HashMap<String, Integer>();
            // index只i后的第index个单词（子字符串）
            int index = 0;
            // 然后开始一小块地遍历
            for (int i = j; i < s.length() - totalLen + 1; i += wordLen) {
                // 是否移除超出次数的词
                boolean removed = false;
                while (index < wordsCount) {
                    // i之后的第index个词
                    int currStart = i + index * wordLen;
                    int currEnd = i + (index + 1) * wordLen;
                    var currWord = s.substring(currStart, currEnd);
                    // 如果字典中有这个词
                    if (dict.containsKey(currWord)) {
                        // 已经出现次数+1
                        int times = map.getOrDefault(currWord, 0);
                        map.put(currWord, times + 1);
                        // 如果已经出现的次数（map）大于dict中有的次数,窗口向前移
                        if (map.get(currWord) > dict.get(currWord)) {
                            removed = true;
                            int removeIndex = 0;
                            // 迭代移除前面的词，直到这个词在map中保存的次数和dict中一致
                            // 相当于删除currWord的上一次出现，与在其之前出现的所有词
                            while (map.get(currWord) > dict.get(currWord)) {
                                int removeStart = i + removeIndex * wordLen;
                                int removeEnd = i + (removeIndex + 1) * wordLen;
                                var removeWord = s.substring(removeStart, removeEnd);
                                map.put(removeWord, map.get(removeWord) - 1);
                                removeIndex++;
                            }
                            // 删除完之后，前移i，减小index
                            index += (-removeIndex + 1);
                            i += (removeIndex - 1) * wordLen;
                            break;
                        }
                    } else { // 如果字典中没有这个词，这一段就无效了，全部重置
                        map.clear();
                        i += index * wordLen;
                        index = 0;
                        break;
                    }
                    index++;
                }
                if (index == wordsCount) {
                    result.add(i);
                }
                // 如果上一次完全匹配（不匹配的话 remove就等于0了）
                if (index > 0 && !removed) {
                    var removeWord = s.substring(i, i + wordLen);
                    map.put(removeWord, map.get(removeWord) - 1);
                    index -= 1;
                }
            }
        }
        return result;
    }
}
