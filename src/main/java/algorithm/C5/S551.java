package algorithm.C5;

public class S551 {
    public boolean checkRecord(String s) {
        // A数量小于2
        // 连续的L小于3
        char[] chars = s.toCharArray();
        int a = 0;
        for (char c : chars) {
            if (c == 'A') {
                if (++a >= 2) return false;
            }
        }
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == 'L') {
                if (i + 2 < chars.length && chars[i + 1] == 'L' && chars[i + 2] == 'L') return false;
            }
            i++;
        }
        return true;
    }
}
