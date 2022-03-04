package algorithm.C3;

import java.util.Arrays;

public class S397 {

    public int integerReplacement(int t) {
        // 找到最优策略
        int count = 0;
        long n = t;
        while (n != 1) {
            // 11
            if ((n & 3) == 3 && n != 3) {
                n++;
            }
            // 01
            else if ((n & 1) == 1) {
                n--;
            }
            // 10 00
            else {
                n = n >> 1;
            }
            count++;
        }
        return count;
    }
}
