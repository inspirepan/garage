package algorithm.C3;

public class S397 {

    class Solution {
        // 递归的写法
        // 还可以，最优的策略就是偶数除以2，奇数考虑+1或者-1中最小的
        public int integerReplacement(int n) {
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            if ((n & 1) == 0) {
                return integerReplacement(n >>> 1) + 1;
            } else {
                return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
            }
        }
    }

    class Solution2 {
        public int integerReplacement(int n) {
            // 最优策略：偶数直接除2，奇数如果+1是4的倍数，那么就+1，否则-1
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            if (n == 4) {
                return 2;
            }
            if ((n & 1) == 0) {
                return integerReplacement(n >>> 1) + 1;
            }
            if (((n + 1) & 3) == 0) {
                return integerReplacement(n + 1) + 1;
            } else {
                return integerReplacement(n - 1) + 1;
            }
        }
    }
}
