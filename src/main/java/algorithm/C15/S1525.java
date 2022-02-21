package algorithm.C15;

import java.util.Set;

public class S1525 {
    public int numSplits(String s) {
        // 一种思路就是检查s.len-1个分割，分别看是不是好分割
        if (s.length() <= 1) return 0;
        if (s.length() == 2) return 1;
        int[] left = new int[26];
        int leftCount = 0;
        int[] right = new int[26];
        int rightCount = 0;
        // 开局左边一个字符
        // 统计一下开局情况
        left[s.charAt(0) - 'a'] = 1;
        leftCount = 1;
        for (int i = 1; i < s.length(); i++) if (right[s.charAt(i) - 'a']++ == 0) rightCount++;
        //split是当前从右边加入到左边的字符
        int split = 1;
        int niceSplitCount = leftCount == rightCount ? 1 : 0;
        while (split < s.length() - 1) {
            char curr = s.charAt(split);
            if (left[curr - 'a']++ == 0) leftCount++;
            if (--right[curr - 'a'] == 0) rightCount--;
            split++;
            if (leftCount == rightCount) niceSplitCount++;
        }
        return niceSplitCount;
    }
}
