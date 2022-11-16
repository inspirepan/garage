package algorithm.c10;

public class S1062 {
    // 挺迷惑的，居然是on2的解法
    public int longestRepeatingSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        int count = 1;
        for (int i = 1; count < len - i; i++) {
            int idx = 0, temp = 0;
            for (int j = i; count - temp < len - j; j++) {
                if (arr[idx++] == arr[j]) {
                    temp++;
                    if (temp > count) {
                        count = temp;
                    }
                } else {
                    temp = 0;
                }
            }
        }
        return count == 1 ? 0 : count;
    }
}
