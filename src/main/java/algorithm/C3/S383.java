package algorithm.C3;

public class S383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charMap = new int[26];
        for (char c : magazine.toCharArray()) {
            charMap[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--charMap[c - 'a'] < 0) return false;
        }
        return true;
    }
}
