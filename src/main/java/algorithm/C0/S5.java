package algorithm.C0;

public class S5 {

    /**
     * 中心扩散 2ms
     */
    public String longestPalindrome(String s) {

        if (s.length() == 0) {
            return s;
        }
        int[] res = new int[2];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = find(c, i, res);
        }
        return s.substring(res[0], res[1] + 1);
    }

    public int find(char[] c, int left, int[] res) {

        int right = left;
        while (right + 1 < c.length && c[right + 1] == c[right]) {
            right++;
        }
        // 返回的值应该是重复字符部分最右边的，即循环的下一次起始位置（left）
        int next = right;

        while (left > 0 && right + 1 < c.length && c[left - 1] == c[right + 1]) {
            left--;
            right++;
        }
        if (right - left > res[1] - res[0]) {
            res[0] = left;
            res[1] = right;
        }

        return next;
    }
}
