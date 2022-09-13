package algorithm.c0;

/**
 * 思路就是记录每次*号匹配的位置，尝试使用*号之后的字符串匹配，如果不能就把j重置到*号后面（用*号匹配全部）
 */
public class S44 {
    public boolean isMatch(String s, String p) {
        // 从头开始匹配，u指的是*的坐标
        int i = 0, j = 0, position = 0, u = -1;
        while (i < s.length()) {
            if (j < p.length()) {
                // ?号匹配一个字符
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    ++i;
                    ++j;
                    continue;
                }
                // 遇到一个*号
                if (p.charAt(j) == '*') {
                    u = j++;
                    // *号后面没有字符了
                    if (j == p.length()) {
                        return true;
                    }
                    // position之前的都是（通过*号）匹配好的，i在position之后说明是用*号之后的字符i与j一起匹配的
                    position = i;
                    continue;
                }
            }
            // u!=-1说明现在正在尝试匹配*号，可以匹配任意字符串，每次只要把j拉回*号后面的那一个字符就可以了
            if (u != -1) {
                i = ++position;
                j = u + 1;
                continue;
            }
            // 啥也没匹配到
            return false;
        }
        // 末尾的*号可以随意匹配
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        return j == p.length();
    }
}
