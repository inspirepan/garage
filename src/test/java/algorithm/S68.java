package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 填空格，细节处理
 * 0ms 100%
 */
public class S68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int len = words.length;
        // 先算出一行需要填空的单词
        // 一行的起始与终止单词
        int start = 0;
        int end = 0;
        int sumLen = 0;
        while (end < len) {
            while (end < len && sumLen + words[end].length() <= maxWidth) {
                sumLen += words[end].length() + 1;
                end++;
            }
            var sb = new StringBuilder();
            // 特殊情况，最后一行
            if (end == len) {
                for (int i = start; i < len; i++) {
                    sb.append(words[i]);
                    if (i < len - 1) {
                        sb.append(" ");
                    }
                }
                sb.append(" ".repeat(maxWidth - sumLen + 1));
            } else {

                // 正常情况，此时需要添加start到end-1的单词
                // 此时sumLen包括所有单词的长度和每个单词后面固定一个空格
                int spaceCount = maxWidth + 1 - sumLen;
                int wordCount = end - start;
                // 如果只有一个单词
                if (wordCount == 1) {
                    sb.append(words[start]);
                    sb.append(" ".repeat(maxWidth - sumLen + 1));
                } else {
                    // 平均分配空格
                    int spaceAvg = spaceCount / (wordCount - 1);
                    // 剩余的空格数
                    int spaceExtra = spaceCount % (wordCount - 1);
                    for (int i = start; i < end; i++) {
                        sb.append(words[i]);
                        // 单词中间的空格
                        if (i < end - 1) {
                            // 固定一个空格和平均空格
                            sb.append(" ".repeat(spaceAvg + 1));
                            if (spaceExtra-- > 0) {
                                sb.append(" ");
                            }
                        }
                    }
                }
            }
            result.add(sb.toString());
            // 更新起始位置
            start = end;
            sumLen = 0;
            System.out.println(result);
        }
        return result;
    }
}