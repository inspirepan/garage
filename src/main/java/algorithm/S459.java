package algorithm;

public class S459 {
    /* 扩成两倍之后掐头去尾，如果重复肯定包含原字符串 */

    public static boolean repeatedSubstringPattern2(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

    /* 如果不能使用contains呢 */

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        if (len < 2) {
            return false;
        }
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                boolean flag = true;
                int j = 0;
                String mod = s.substring(j, i);
                j += i;
                while (j + i <= len) {
                    if (!s.substring(j, j + i).equals(mod)) {
                        flag = false;
                        break;
                    }
                    j += i;
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern3(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        if (len < 2) {
            return false;
        }
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                boolean flag = true;
                int j = len;
                String mod = s.substring(0, i);
                while (j >= 2 * i) {
                    if (!s.substring(j - i, j).equals(mod)) {
                        flag = false;
                        break;
                    }
                    j -= i;
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
