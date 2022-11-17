package algorithm.c10;

/**
 * @author : panjixiang
 * @since : 2022/11/16
 */
public class S1006 {
    class Solution {
        public int clumsy(int n) {
            // 模拟?
            // 以4个为一组进行计算
            // 最后再重新计算一下开头的三个
            int res = 0;
            // 小于4要另外判一下，因为 2/(n+1) 大于 1 了，不能套用公式了
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else if (n == 3) {
                return 6;
            } else if (n == 4) {
                return 7;
            }
            res += 2 * (n + 1);
            while (n > 4) {
                res -= 4;
                n -= 4;
            }
            switch (n) {
                case 4 -> res -= 5;
                case 3 -> res -= 6;
                case 2 -> res -= 2;
                case 1 -> res -= 1;
            }
            return res;
        }
    }
}




