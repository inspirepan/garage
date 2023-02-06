package algorithm.c3;

import java.util.PriorityQueue;

public class S313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        // prime是质数，求primes各种组合中第n个，1固定第一个
        // 可以用PriorityQueue，然后每次都是第一个乘以第二个，或者第一个数的平方
        // 不对 那我怎么确定第n个呢
        // a b c
        // a a*a|b 一旦选择了b，接下来每个选择都要判断c
        // 感觉这个思路不对，不能自己去生成，应该从1开始往上判断是不是质因数只有primes中间的 —> 这个方案超时了

        // 还是看了题解，用最小堆，生成n次，每次把当前堆中最小，乘以primes中的所有数，用pq来找到其中的最小值就可以了，每次primes都乘一下，不会错过数
        var queue = new PriorityQueue<Long>();
        long res = 1;
        for (int i = 1; i < n; i++) {
            for (int prime : primes) {
                queue.add(prime * res);
            }
            res = queue.poll();
            while (!queue.isEmpty() && res == queue.peek()) {
                queue.poll();
            }
        }
        return (int) res;
    }
}
