package algorithm.F1;

import java.util.*;

public class S49 {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        if (n == 5) return 5;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(5);
        Set<Integer> set = new HashSet<>();
        set.addAll(pq);
        int t = 0;
        int[] factors = new int[]{2, 3, 5};
        while (n > 0) {
            t = pq.poll();
            for (int factor : factors) {
                if ((long) t * factor > Integer.MAX_VALUE) {
                    continue;
                }
                if (!set.contains(t * factor)) {
                    pq.offer(t * factor);
                    set.add(t * factor);
                }
            }
            n--;
        }
        return t;
    }
}
