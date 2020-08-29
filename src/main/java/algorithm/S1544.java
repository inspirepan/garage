package algorithm;

public class S1544 {
    public String makeGood(String s) {
        var sb = new StringBuilder(s);
        int len = -1;
        while (len != sb.length()) {
            len = sb.length();
            for (int i = 0; i < sb.length() - 1; i++) {
                if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == 'a' - 'A') {
                    sb.delete(i, i + 2);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
