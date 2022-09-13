package algorithm.F2;

public class S34 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < 26; i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], orders) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String a, String b, int[] o) {
        int i = 0;
        int j = 0;

        while (i < a.length() || j < b.length()) {
            if (i >= a.length()) {
                return -1;
            }
            if (j >= b.length()) {
                return 1;
            }
            char a1 = a.charAt(i++);
            char b1 = b.charAt(j++);
            int cmp = o[a1 - 'a'] - o[b1 - 'a'];
            if (cmp > 0) {
                return 1;
            } else if (cmp < 0) {
                return -1;
            }
        }
        return 0;
    }
}
