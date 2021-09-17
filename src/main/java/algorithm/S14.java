package algorithm;

public class S14 {
    public String longestCommonPrefix(String[] strs) {
        //找最短长度
        int minLen = strs[0].length();
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            boolean same = true;
            for (int i1 = 1; i1 < strs.length; i1++) {
                if (strs[i1].charAt(i) != c) {
                    same = false;
                    break;
                }
            }
            if (same) {
                sb.append(c);
            } else break;
        }
        return sb.toString();
    }
}
