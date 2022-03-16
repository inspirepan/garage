package algorithm.C5;

public class S556 {
    public int nextGreaterElement(int n) {
        // 转换成字符串
        // 相当于数字全排列的下一个元素
        // 从末尾开始，找到第一个升序，然后互换的位置（互换升序和末尾的，然后逆序后面一节）
        // 如果没有升序，返回-1
        // 49876 64789
        // 46798 46879
        //
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int len = chars.length;

        int p = len - 1;
        while (p >= 1) {
            int numP = chars[p] - '0';
            int numNext = chars[p - 1] - '0';
            if (numNext < numP) break;
            p--;
        }
        if (p == 0) return -1;
        // 找到第一个大于它的
        int q = len - 1;
        while (q > p && (chars[q] - '0' <= chars[p - 1] - '0')) {
            q--;
        }
        char temp = chars[p - 1];
        chars[p - 1] = chars[q];
        chars[q] = temp;
        reverse(chars, p, q);
        long ans = Long.parseLong(new String(chars));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private void reverse(char[] c, int left, int right) {
        // 翻转[left,right]
        while (left < right) {
            char t = c[left];
            c[left] = c[right];
            c[right] = t;
            left++;
            right--;
        }
    }
}
