package algorithm.F1;

public class S50 {
    public char firstUniqChar(String s) {
        int[] count = new int[1000];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            if (count[c] == 1) return c;
        }
        return ' ';
    }
}
