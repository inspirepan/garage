package algorithm.F1;

public class S58II {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        if (n % len == 0) {
            return s;
        }
        n %= len;
        return s.substring(n, len) + s.substring(0, n);
    }
}
