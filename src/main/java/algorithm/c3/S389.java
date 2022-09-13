package algorithm.c3;

public class S389 {
    public char findTheDifference(String s, String t) {
        int[] cmap = new int[26];
        for (char c : s.toCharArray()) {
            cmap[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--cmap[c - 'a'] < 0) {
                return c;
            }
        }
        return 'a';
    }
}
