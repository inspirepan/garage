package algorithm.C6;

import java.util.ArrayList;
import java.util.List;

public class S625 {
    public int smallestFactorization(int num) {
        // b的所有数位，所以一定是分解成个位数，如果因数有大于10的质数怎么办，那就返回0
        // 应该是尽量用个位数去除原数，从9开始除，然后再从小到大组装
        if (num <= 9) return num;
        var sb = new StringBuilder();
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                num /= i;
                sb.append(i);
            }
        }
        if (num != 1) return 0;
        long ans = Long.parseLong(sb.reverse().toString());
        if (ans > Integer.MAX_VALUE) return 0;
        return (int) ans;
    }
}
