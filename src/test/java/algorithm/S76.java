package algorithm;

/**
 * 思路就是每次检查是否符合要求，符合就左指针右移缩小区间，不符合就右指针右移扩大区间
 * 看了效率更高的答案，应该是用额外的一个数组记录<s中出现的t中需要的字符>的次数，
 * 每一次记录当前添加、减少的字符是否是需要的字符，如果是，再对应修改count数（left-right区间内有效字符数），
 * 如果count数和t长度一样，就比较长度与minLength，提供结果
 */
public class S76 {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0 || s.length() < t.length()) {
            return "";
        }
        // 记录t中出现字符的次数
        int[] record = new int[58];
        for (char c : t.toCharArray()) {
            record[c - 'A']++;
        }
        int left = 0, right = 0, minLength = Integer.MAX_VALUE;
        int[] result = new int[2];
        boolean satisfied = false;
        while (right < s.length() || left <= s.length() - t.length()) {
            // right已到边界
            if (satisfied) {
                if (minLength > right - left) {
                    minLength = right - left;
                    result[0] = left;
                    result[1] = right;
                }
                record[s.charAt(left++) - 'A']++;
            } else {
                // 已经右边界了
                if (right == s.length()) {
                    break;
                }
                record[s.charAt(right++) - 'A']--;
            }
            satisfied = checkWindow(record);
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1]);
    }

    private boolean checkWindow(int[] record) {
        for (int c : record) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }
}
