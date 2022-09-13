package algorithm.f1;

public class S20 {
    public boolean isNumber(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        // 遇到e，检查后面的部分是不是整数 isInteger
        if (chars.length == 0) {
            return false;
        }
        int i;
        // 检查符号位
        if (chars[0] == '+' || chars[0] == '-') {
            if (chars.length == 1) {
                return false;
            }
            i = 1;
        } else {
            i = 0;
        }
        // 检查数字部分
        // 记录小数点和是否出现过数字
        boolean hasDot = false;
        boolean hasNumber = false;
        while (i < chars.length) {
            if (chars[i] == '.') {
                if (hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // e前面必须有数
                if (!hasNumber) {
                    return false;
                }
                // e后面必须接一个整数
                return isInteger(s.substring(i + 1, chars.length));
            } else if (!isNumberDigit(chars[i])) {
                // 其他字符
                return false;
            } else {
                // 数字
                hasNumber = true;
            }
            i++;
        }
        return hasNumber;
    }

    private boolean isInteger(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return false;
        }
        int i;
        // 带有正负号
        if (chars[0] == '+' || chars[0] == '-') {
            if (chars.length == 1) {
                return false;
            }
            i = 1;
        } else {
            i = 0;
        }
        // 检查数字部分
        while (i < chars.length) {
            if (!isNumberDigit(chars[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isNumberDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
