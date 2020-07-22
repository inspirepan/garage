package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class S93 {

    private List<String> results93;
    private StringBuilder sb93;
    private char[] chars93;

    /* 复原IP地址
     * 采用深度优先搜索
     * 可以转换为摆三个分隔点的问题 */

    public List<String> restoreIpAddresses(String s) {
        results93 = new ArrayList<>();
        sb93 = new StringBuilder();
        chars93 = s.toCharArray();
        dfs93(0, 0);
        return this.results93;
    }

    /**
     * 回溯
     *
     * @param count 当前已经确定的数字
     * @param i     下一个待处理字符的下标
     */
    private void dfs93(int count, int i) {
        if (count == 4 && i == chars93.length) {
            results93.add(sb93.toString());
            return;
        }
        int remain_count = 4 - count;
        int remain_chars = chars93.length - i;
        if (remain_count > remain_chars || remain_count * 3 < remain_chars) {
            return;
        }
        int len = sb93.length();
        int max_len = chars93[i] == '0' ? 1 : 3;
        for (int j = 0; j < max_len && i + j < chars93.length; j++) {
            if (j == 2 && (chars93[i] - '0') * 100 + (chars93[i + 1] - '0') * 10 + (chars93[i + 2] - '0') > 255) {
                continue;
            }
            for (int k = 0; k <= j; k++) {
                sb93.append(chars93[i + k]);
            }
            if (count < 3) {
                sb93.append('.');
            }
            dfs93(count + 1, i + j + 1);
            sb93.delete(len, count < 3 ? len + j + 2 : len + j + 1);
        }
    }
}

