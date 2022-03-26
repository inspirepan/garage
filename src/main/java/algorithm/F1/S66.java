package algorithm.F1;

public class S66 {
    public int strToInt(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        if (chars.length == 0) return 0;
        int i = 0;
        boolean isNegative = false;
        if (chars[0] == '+' || chars[0] == '-') {
            if (chars[0] == '-') isNegative = true;
            i = 1;
        }
        long result = 0;
        while (i < chars.length) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            result *= 10;
            result += chars[i] - '0';
            if (result > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }
        return (int) (isNegative ? -result : result);
    }
}
