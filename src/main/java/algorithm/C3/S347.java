package algorithm.C3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class S347 {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        var pq = new PriorityQueue<Integer>((Comparator.comparingInt(map::get)));
        for (int num : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (map.get(num) > map.get(pq.peek())) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        var res = new int[k];
        for (int i = 0; i < res.length; i++) {
            assert !pq.isEmpty();
            res[i] = pq.poll();
        }
        return res;
    }
}
