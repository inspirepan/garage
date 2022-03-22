package algorithm.C7;

public class S709 {
    public String toLowerCase(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] <= 'Z' && c[i] >= 'A') {
                c[i] += 'a' - 'A';
            }
        }
        return new String(c);
    }
}
