package algorithm.C4;

public class S467 {
    public int findSubstringInWraproundString(String p) {
        // 统计p中的连续字符串，注意处理z-a
        // 子串要是唯一的！
        // 看得题解，统计每种字符结尾的最长子串
        char[] c = p.toCharArray();
        if (c.length == 1) {
            return 1;
        }
        int[] cmap = new int[26];
        char prev = c[0];
        cmap[c[0] - 'a'] = 1;
        int start = 0;
        int i = 1;
        while (i < c.length) {
            // 不连续，更新start
            boolean cont = (c[i] - prev == 1) || (prev == 'z' && c[i] == 'a');
            if (!cont) {
                start = i; // 从start开始
            }
            // 如果没有统计过，或者之前长度更短
            cmap[c[i] - 'a'] = Math.max(i - start + 1, cmap[c[i] - 'a']);
            prev = c[i++];
        }
        int result = 0;
        for (int d : cmap) {
            result += d;
        }
        return result;
    }
}
