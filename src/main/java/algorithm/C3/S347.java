package algorithm.C3;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class S347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (var e : map.entrySet()) {
            Number n = new Number(e.getKey(), e.getValue());
            pq.offer(n);
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            assert !pq.isEmpty();
            res[i++] = pq.poll().val;
        }
        return res;
    }

    public static class Number implements Comparable<Number> {
        int val;
        int freq;

        public Number(int n, int freq) {
            this.val = n;
            this.freq = freq;
        }

        @Override
        public int compareTo(Number o) {
            if (this.freq == o.freq) {
                return 0;
            }
            return this.freq < o.freq ? 1 : -1;
        }
    }
}
