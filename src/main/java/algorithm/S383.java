package algorithm;

public class S383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rec = new int[26];
        for (char c : ransomNote.toCharArray()) {
            rec[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            rec[c - 'a']--;
        }
        for (int i : rec) {
            if (i > 0) return false;
        }
        return true;
    }
}
