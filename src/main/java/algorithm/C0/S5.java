package algorithm.C0;

public class S5 {

    /**
     * 中心扩散 2ms
     *
     */
    public String longestPalindrome(String s) {

        if (s.length() == 0) {
            return s;
        }
        // 用数组来记录两个值
        int[] se = new int[2];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = find(c, i, se);
        }
        return s.substring(se[0], se[1] + 1);

    }

    public int find(char[] c, int left, int[] se) {

        int right = left;
        // 先找最中间重复字符的部分
        while (right + 1 < c.length && c[right + 1] == c[right]) {
            right++;
        }
        // 返回的值应该是重复字符部分最右边的，即循环的下一次起始位置（left）
        int mid = right;

        // 向左右扩充
        while (left > 0 && right + 1 < c.length && c[left - 1] == c[right + 1]) {
            left--;
            right++;
        }
        if (right - left > se[1] - se[0]) {
            se[0] = left;
            se[1] = right;
        }

        return mid;

    }
}
