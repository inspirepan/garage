package algorithm.F1;

public class S05 {
    public String replaceSpace(String s) {
        char[] cArr = s.toCharArray();
        var sb = new StringBuilder();
        for (char c : cArr) {
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
