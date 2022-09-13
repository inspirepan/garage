package algorithm.c9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S937 {
    public String[] reorderLogFiles(String[] logs) {
        // 看了题解，才发现其实返回0就可以保留原来的顺序了

        // 不过我直接把数字日志先提取出来，效率更加高吧减少了比较的次数
        // 另外String.split()的第二个参数可以控制分成几份，这一点要学习一下

        String[] ans = new String[logs.length];
        int index = logs.length - 1;
        List<String> alphabetLogs = new ArrayList<>();
        for (int i = logs.length - 1; i >= 0; i--) {
            String log = logs[i];
            int idx = log.indexOf(' ');
            if (Character.isAlphabetic(log.charAt(idx + 1))) {
                alphabetLogs.add(log);
            } else {
                ans[index--] = log;
            }
        }
        Collections.sort(alphabetLogs, (o1, o2) -> {
            int idx1 = o1.indexOf(' ');
            int idx2 = o2.indexOf(' ');
            int cmp = o1.substring(idx1 + 1).compareTo(o2.substring(idx2 + 1));
            if (cmp != 0) {
                return cmp;
            }
            return o1.substring(0, idx1).compareTo(o2.substring(0, idx2));
        });
        index = 0;
        for (String log : alphabetLogs) {
            ans[index++] = log;
        }
        return ans;
    }
}
