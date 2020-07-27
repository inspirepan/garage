package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class S93 {

    private List<String> results;
    private StringBuilder sb;
    private char[] chars;

    /*
     * 复原IP地址 采用深度优先搜索 可以转换为摆三个分隔点的问题
     */

    public List<String> restoreIpAddresses(String s) {
        results = new ArrayList<>();
        sb = new StringBuilder();
        chars = s.toCharArray();
        dfs93(0, 0);
        return this.results;
    }

    /**
     * 回溯
     *
     * @param count 当前已经确定的数字
     * @param i     下一个待处理字符的下标
     */
    private void dfs93(int count, int i) {
        if (count == 4 && i == chars.length) {
            results.add(sb.toString());
            return;
        }
        int remain_count = 4 - count;
        int remain_chars = chars.length - i;
        if (remain_count > remain_chars || remain_count * 3 < remain_chars) {
            return;
        }
        int len = sb.length();
        int max_len = chars[i] == '0' ? 1 : 3;
        for (int j = 0; j < max_len && i + j < chars.length; j++) {
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
