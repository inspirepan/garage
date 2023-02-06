package algorithm.c5;

public class S555 {
    public String splitLoopedString(String[] strs) {
        // 对于每一个字符串，检查翻转之后的字母序是不是大于它，翻转成更大字母序
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0) {
                strs[i] = rev;
            }
        }
        // 怎么选择切割位置？？？？没有什么技巧，手动遍历全部情况，选择字母序最大的位置
        char max = 'a';
        String ans = "";
        // 遍历全部的字符串
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            // 翻转
            int len = strs[i].length();
            for (String s : new String[]{strs[i], rev}) {
                for (int j = 0; j < len; j++) {
                    // 考虑当前字符串的每一个字符
                    if (s.charAt(j) < max) {
                        continue;
                    }
                    //
                    StringBuilder tmp = new StringBuilder(s.substring(j));
                    for (int k = i + 1; k < strs.length; k++) {
                        tmp.append(strs[k]);
                    }
                    for (int k = 0; k < i; k++) {
                        tmp.append(strs[k]);
                    }
                    tmp.append(s, 0, j);
                    if (ans.compareTo(tmp.toString()) < 0) {
                        ans = tmp.toString();
                    }
                }
            }
        }
        return ans;
    }
}
