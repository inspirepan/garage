package algorithm.C5;

import java.util.HashSet;
import java.util.Set;

public class S522 {
    public int findLUSlength(String[] strs) {
        // 跟上一题思路类似，首先，相同的肯定不行，
        // 另外 一个字符串如果是另一个的子序列，那也不行，
        if (strs.length == 1) return strs[0].length();
        if (strs.length == 0) return 0;
        Set<String> all = new HashSet<>();
        Set<String> distinct = new HashSet<>();
        int maxLen = -1;
        for (String s : strs) {
            if (all.contains(s)) {
                if (distinct.contains(s)) distinct.remove(s);
            } else {
                distinct.add(s);
            }
            all.add(s);
        }
        for (String s : distinct) {
            boolean flag = false;
            for (String k : all) {
                if (k.equals(s)) continue;
                // 判断子序列
                if (checkSubSequence(k, s)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                maxLen = Math.max(maxLen, s.length());
            }
        }
        return maxLen;
    }

    private boolean checkSubSequence(String k, String s) {
        if (k.length() <= s.length()) return false;
        int i = 0;
        int j = 0;
        while (j < s.length() && i < k.length()) {
            if (k.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == s.length();
    }
}
