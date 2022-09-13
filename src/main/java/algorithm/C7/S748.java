package algorithm.C7;

import java.util.Arrays;

public class S748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        countLetters(licensePlate, count);
        int minLength = Integer.MAX_VALUE;
        String minWord = "";
        int[] wCount = new int[26];
        for (String word : words) {
            countLetters(word, wCount);
            if (contains(wCount, count)) {
                if (word.length() < minLength) {
                    minLength = word.length();
                    minWord = word;
                }
            }
        }
        return minWord;
    }

    private boolean contains(int[] wCount, int[] count) {
        for (int i = 0; i < 26; i++) {
            if (wCount[i] < count[i]) {
                return false;
            }
        }
        return true;
    }

    private void countLetters(String s, int[] count) {
        // ignore space & num
        // ignore uppercase
        Arrays.fill(count, 0);
        for (char c : s.toCharArray()) {
            if (c == ' ' || (c >= '0' && c <= '9')) {
                continue;
            }
            if (c >= 'a') {
                count[c - 'a']++;
            } else if (c >= 'A') {
                count[c - 'A']++;
            }
        }
    }
}
