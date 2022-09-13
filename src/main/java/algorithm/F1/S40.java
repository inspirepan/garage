package algorithm.F1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class S40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int size = pq.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
