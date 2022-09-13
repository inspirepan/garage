package algorithm.c15;

public class S1556 {
    public String thousandSeparator(int n) {
        var sb = new StringBuilder(String.valueOf(n));
        int i = sb.length() - 1;
        int count = 0;
        while (i >= 0) {
            count++;
            if (count == 3) {
                if (i != 0) {
                    sb.insert(i, '.');
                }
                count = 0;
            }
            i--;
        }
        return sb.toString();
    }
}
