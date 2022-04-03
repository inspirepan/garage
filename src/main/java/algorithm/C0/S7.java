package algorithm.C0;

public class S7 {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        int res = 0;
        while (x > 0) {
            // 每一步都要判断越界
            if (res > Integer.MAX_VALUE / 10) return 0;
            res *= 10;
            if (res > Integer.MAX_VALUE - x % 10) return 0;
            res += x % 10;
            x /= 10;
        }
        return flag ? -res : res;
    }
}
