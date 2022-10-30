package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/10/31
 */
public class S984 {
    public String strWithout3a3b(int a, int b) {
        // 如果a更多，就aabaabaab这样子
        // 如果b更多，就bbabbabba
        // 差值
        // ababababababa
        // 往abab里面插入，最贪的做法，实际上ab差值最大为3
        if (a == b) {
            return "ab".repeat(a);
        } else if (a > b) {
            int k = a - b - 1;
            var sb = new StringBuilder();
            sb.append("a");
            for (int i = 0; i < b; i++) {
                sb.append("ab");
                if (k-- > 0) {
                    sb.append("a");
                }
            }
            while (k-- > 0) {
                sb.append("a");
            }
            return sb.toString();
        } else {
            int k = b - a - 1;
            var sb = new StringBuilder();
            sb.append("b");
            for (int i = 0; i < a; i++) {
                sb.append("ba");
                if (k-- > 0) {
                    sb.append("b");
                }
            }
            while (k-- > 0) {
                sb.append("b");
            }
            return sb.toString();
        }
    }
}
