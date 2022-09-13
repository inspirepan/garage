package algorithm.c8;

public class S821 {
    public int[] shortestToChar(String s, char c) {
        // 可以从左往右、从右往左各扫描一遍
        int len = s.length();
        int[] ans = new int[len];
        int i = 0;
        int prev = -len - 1;
        while (i < len) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                for (int k = Math.max(0, prev + 1); k < i; k++) {
                    ans[k] = Math.min(k - prev, i - k);
                }
                prev = i;
            }
            i++;
        }
        for (int k = prev + 1; k < len; k++) {
            ans[k] = k - prev;
        }
        return ans;
    }
}
