package algorithm.C3;

public class S306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        // 先确定前两个数，考虑前导0
        if (num.charAt(0) == '0') {
            // 第一个数必须是0
            if (num.charAt(1) == '0') {
                // 第二个数也是0
                return helper(2, "0", "0", num);
            } else {
                for (int i = 2; i <= num.length(); i++) {
                    String curr = num.substring(1, i);
                    if (helper(i, curr, curr, num)) return true;
                }
            }
            return false;
        }
        // 选两个数
        for (int i = 1; i < num.length(); i++) {
            String first = num.substring(0, i);
            // 考虑第二个数的0
            if (num.charAt(i) == '0') {
                if (helper(i + 1, first, "0", num)) return true;
            } else {
                for (int j = i + 1; j < num.length(); j++) {
                    String sec = num.substring(i, j);
                    if (helper(j, add(first, sec), sec, num)) return true;
                }
            }
        }
        return false;
    }

    boolean helper(int start, String expect, String prev, String num) {
        // i 当前起点
        // expectSum 期望i开始的和
        // prevNum 上一个数
        int nextLen = expect.length();
        if (nextLen + start > num.length()) return false;
        if (!num.substring(start, start + nextLen).equals(expect)) return false;
        if (start + nextLen == num.length()) return true;
        return helper(start + nextLen, add(expect, prev), expect, num);
    }

    static String add(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int i = ca.length - 1, j = cb.length - 1;
        var sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit = carry;
            if (i >= 0) digit += ca[i--] - '0';
            if (j >= 0) digit += cb[j--] - '0';
            carry = digit >= 10 ? 1 : 0;
            digit = digit >= 10 ? digit - 10 : digit;
            sb.append(digit);
        }
        return sb.reverse().toString();
    }
}
