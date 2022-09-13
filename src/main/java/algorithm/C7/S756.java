package algorithm.C7;

import java.util.List;

class S756 {
    int[][] map = new int[7][7];

    public boolean pyramidTransition(String bottom, List<String> allowed) {  /* main */
        for (String s : allowed) {
            map[s.charAt(0) - 'A'][s.charAt(1) - 'A'] |= (1 << (s.charAt(2) - 'A'));
        }
        return dfs(bottom, new StringBuilder());
    }

    private boolean dfs(String pre, StringBuilder cur) {  // pre是前一层，cur是当前层
        int preLen = pre.length(), curLen = cur.length();
        if (preLen == 1)  // 已构建完最后一层
        {
            return true;
        }
        if (curLen + 1 == preLen)  // 已构建完当前层
        {
            return dfs(cur.toString(), new StringBuilder());
        }
        int a = pre.charAt(curLen) - 'A', b = pre.charAt(curLen + 1) - 'A';
        if (map[a][b] > 0) {
            int i = 0;
            while (i < 7) {
                if ((map[a][b] & (1 << i)) != 0) {
                    char c = (char) (i + 'A');
                    cur.append(c);
                    if (dfs(pre, cur)) {
                        return true;
                    }
                    cur.setLength(cur.length() - 1);
                }
                i++;
            }
        }
        return false;
    }
}