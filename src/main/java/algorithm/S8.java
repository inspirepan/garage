package algorithm;

/**
 * @author panjx
 */
public class S8 {
    /**
     * 转换成数字，细心一点即可
     */
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        // 去掉前置空格
        int firstNotNull = 0;
        while (firstNotNull < str.length() && str.charAt(firstNotNull) == ' ') {
            firstNotNull++;
        }
        if (firstNotNull == str.length()) {
            return 0;
        }
        String s = str.substring(firstNotNull);

        int p = 0;
        boolean hasNumber = false;
        boolean negative = false;
        // 处理首位加减号
        if (s.charAt(0) == '+') {
            p++;
        }
        if (s.charAt(0) == '-') {
            p++;
            negative = true;
        }
        char curr;
        int ans = 0;
        while (p < s.length() && (curr = s.charAt(p)) >= '0' && curr <= '9') {
            int currNum = curr - '0';
            if (ans > (Integer.MAX_VALUE - currNum) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + currNum;
            hasNumber = true;
            p++;
        }
        if (!hasNumber) {
            return 0;
        }
        return negative ? -ans : ans;
    }
}
