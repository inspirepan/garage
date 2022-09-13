package algorithm.c15;

public class S1544 {
    public String makeGood(String s) {
        if (s.length() == 0) {
            return s;
        }
        final int DIST = 'a' - 'A';
        StringBuilder sb = new StringBuilder(s);
        int len = -1;
        while (len != sb.length()) {
            len = sb.length();
            for (int i = 0; i < sb.length() - 1; i++) {
                if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == DIST) {
                    sb.delete(i, i + 2);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
