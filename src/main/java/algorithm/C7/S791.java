package algorithm.C7;

public class S791 {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        char[] sArr = s.toCharArray();
        int[] count = new int[26];
        for (char c : sArr) {
            count[c - 'a']++;
        }
        for (char c : order.toCharArray()) {
            if (count[c - 'a'] > 0) {
                while (count[c - 'a'] > 0) {
                    sb.append(c);
                    count[c - 'a']--;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            if (count[i] > 0) {
                while (count[i] > 0) {
                    sb.append(c);
                    count[i]--;
                }
            }
        }
        return sb.toString();
    }
}
