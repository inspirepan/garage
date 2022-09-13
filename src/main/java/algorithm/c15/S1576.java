package algorithm.c15;

public class S1576 {
    public String modifyString(String s) {
        // 只要不连续就可以了
        // 细节不够多，没考虑z+1的情况
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                // 替换
                char d = 'a';
                if (i > 0) {
                    d = (char) (chars[i - 1] + 1);
                    if (d == '{') {
                        d = 'a';
                    }
                }
                if (i < chars.length - 1 && d == chars[i + 1]) {
                    d = (char) (chars[i + 1] + 1);
                    // 考虑z+1可能会变成{
                    if (d == '{') {
                        d = 'a';
                    }
                }
                chars[i] = d;
            }
        }
        return new String(chars);
    }
}
