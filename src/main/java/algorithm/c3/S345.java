package algorithm.c3;

public class S345 {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (isNotVowel(c[left])) {
                left++;
            } else if (isNotVowel(c[right])) {
                right--;
            } else {
                char t = c[left];
                c[left] = c[right];
                c[right] = t;
                left++;
                right--;
            }
        }
        return new String(c);
    }

    private boolean isNotVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'u' && c != 'o' && c != 'A' && c != 'E' && c != 'I' && c != 'U' && c != 'O';
    }
}
