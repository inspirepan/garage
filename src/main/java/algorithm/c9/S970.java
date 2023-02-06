package algorithm.c9;

import java.util.*;

/**
 * @author : panjixiang
 * @since : 2022/9/27
 */
public class S970 {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i1 = x == 1 ? 0 : (int) Math.floor(Math.log(bound) / Math.log(x));
        int i2 = y == 1 ? 0 : (int) Math.floor(Math.log(bound) / Math.log(y));
        for (int i = 0; i <= i1; i++) {
            for (int j = 0; j <= i2; j++) {
                pq.add((int) (Math.pow(x, i) + Math.pow(y, j)));
            }
        }
        while (!pq.isEmpty() && pq.peek() <= bound) {
            set.add(pq.poll());
        }
        return new ArrayList<>(set);
    }
}
