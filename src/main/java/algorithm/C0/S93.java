package algorithm.C0;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址 采用深度优先搜索 可以转换为摆三个分隔点的问题
 */
public class S93 {

    private List<String> results;
    private StringBuilder sb;
    private char[] chars;

    public List<String> restoreIpAddresses(String s) {
        results = new ArrayList<>();
        sb = new StringBuilder();
        chars = s.toCharArray();
        dfs93(0, 0);
        return this.results;
    }

    private void dfs93(int count, int i) {
        if (count == 4 && i == chars.length) {
            results.add(sb.toString());
            return;
        }
        int remainCount = 4 - count;
        int remainChars = chars.length - i;
        // stop if remain numbers don't match
        if (remainCount > remainChars || remainCount * 3 < remainChars) {
            return;
        }
        int len = sb.length();
        int max = chars[i] == '0' ? 1 : 3;
        for (int j = 0; j < max && i + j < chars.length; j++) {
            if (j == 2 && (chars[i] - '0') * 100 + (chars[i + 1] - '0') * 10 + (chars[i + 2] - '0') > 255) {
                continue;
            }
            for (int k = 0; k <= j; k++) {
                sb.append(chars[i + k]);
            }
            if (count < 3) {
                sb.append('.');
            }
            dfs93(count + 1, i + j + 1);
            sb.delete(len, count < 3 ? len + j + 2 : len + j + 1);
        }
    }
}
