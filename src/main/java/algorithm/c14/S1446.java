package algorithm.c14;

public class S1446 {
    public int maxPower(String s) {
        int count = 1;
        int max = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                c = s.charAt(i);
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
