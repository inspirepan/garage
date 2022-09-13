package algorithm.c2;

public class S266 {
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[128];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }

        boolean flag = false;
        for (int i = 0; i < 128; i++) {
            if ((cnt[i] & 1) == 1) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
}
