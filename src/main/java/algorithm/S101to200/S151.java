package algorithm.S101to200;

public class S151 {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        reverse(c, 0, s.length() - 1);
        reverseWord(c);
        return removeSpace(c);
    }

    private void reverse(char[] c, int start, int end) {
        while (end > start) {
            char temp = c[end];
            c[end--] = c[start];
            c[start++] = temp;
        }
    }

    private void reverseWord(char[] c) {
        int start = 0;
        int end = 0;
        while (end < c.length) {
            while (start < c.length && c[start] == ' ') {
                start++;
            }
            end = start;
            while (end < c.length && c[end] != ' ') {
                end++;
            }
            reverse(c, start, end - 1);
            start = end;
        }
    }

    private String removeSpace(char[] c) {
        int len = c.length;
        int i = 0;
        int j = 0;
        while (j < len) {
            while (j < len && c[j] == ' ') {
                j++;
            }
            while (j < len && c[j] != ' ') {
                c[i++] = c[j++];
            }
            while (j < len && c[j] == ' ') {
                j++;
            }
            if (j < len) {
                c[i++] = ' ';
            }

        }
        return new String(c).substring(0, i);
    }
}