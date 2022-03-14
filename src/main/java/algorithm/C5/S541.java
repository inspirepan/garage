package algorithm.C5;

public class S541 {
    public String reverseStr(String s, int k) {
        if (k <= 1) return s;
        char[] c = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            int start = i;
            while (i < s.length() && i < start + 2 * k) {
                i++;
            }
            reverse(c, start, Math.min(i, start + k));
        }
        return new String(c);
    }

    private void reverse(char[] c, int start, int end) {
        // [start,end)
        int l = start, r = end - 1;
        while (l < r) {
            swap(c, l++, r--);
        }
    }

    private void swap(char[] c, int a, int b) {
        char t = c[a];
        c[a] = c[b];
        c[b] = t;
    }
}
