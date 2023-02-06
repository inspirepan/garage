package algorithm.c8;

public class S806 {
    public int[] numberOfLines(int[] widths, String s) {
        int x = 0;
        int y = 1;
        for (char c : s.toCharArray()) {
            if (x + widths[c - 'a'] > 100) {
                y++;
                x = widths[c - 'a'];
            } else {
                x += widths[c - 'a'];
            }
        }
        return new int[]{y, x};
    }
}
