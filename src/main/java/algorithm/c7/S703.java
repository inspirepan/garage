package algorithm.c7;

import java.util.PriorityQueue;

public class S703 {
    class KthLargest {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }
}
