package algorithm.C4;

public class S443 {
    public int compress(char[] chars) {
        int i = 0;
        char curr = chars[0];
        int count = 0;
        // p 是新字符串的索引位置
        int p = 0;
        // 常量的空间记录重复字符个数
        while (i < chars.length) {
            if (chars[i] == curr) {
                count++;
            } else {
                // 填入新字母和计数
                chars[p++] = curr;
                if (count > 1) {
                    String k = String.valueOf(count);
                    for (char c : k.toCharArray()) {
                        chars[p++] = c;
                    }
                }
                // 更新新的字符信息
                count = 1;
                curr = chars[i];
            }
            i++;
        }
        // 填入计数
        chars[p++] = curr;
        if (count > 1) {
            String k = String.valueOf(count);
            for (char c : k.toCharArray()) {
                chars[p++] = c;
            }
        }
        return p;
    }
}
