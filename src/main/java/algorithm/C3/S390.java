package algorithm.C3;

public class S390 {
    public int lastRemaining(int n) {
        // 每一次操作会让每一个数之间的距离翻倍
        int step = 1;
        int first = 1;
        // 所以总的操作步数是可定的
        boolean flag = true;
        while (n > 1) {
            if (flag) {
                first += step;
            } else {
                // 如果从右往左是偶数个，那么首个元素是不变的
                // 奇数个就保留第二个
                if ((n & 1) == 1) {
                    first += step;
                }
            }
            step *= 2;
            flag = !flag;
            n /= 2;
        }
        return first;
    }
}
