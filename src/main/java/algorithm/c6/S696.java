package algorithm.c6;

public class S696 {
    public int countBinarySubstrings(String s) {
        // 遍历每一个缝
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            // i] || [i+1
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < s.length() && c[left] == '0' && c[right] == '1') {
                count++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && c[left] == '1' && c[right] == '0') {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}

