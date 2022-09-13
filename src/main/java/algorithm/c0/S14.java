package algorithm.c0;

public class S14 {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        int len = strs[0].length();
        for (String s : strs) {
            len = Math.min(len, s.length());
        }
        boolean flag = false;
        while (i < len) {
            char curr = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != curr) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            i++;
        }
        return strs[0].substring(0, i);
    }
}
