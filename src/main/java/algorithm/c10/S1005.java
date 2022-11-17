package algorithm.c10;

import java.util.PriorityQueue;

/**
 * @author : panjixiang
 * @since : 2022/11/16
 */
public class S1005 {
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            int negCount = 0;
            for (int num : nums) {
                if (num < 0) {
                    negCount++;
                }
            }
            if (negCount <= k) {
                // 那么我们先把全部的都转过来，然后再取最小的(k-negCount)&1个取反？
                int min = Math.abs(nums[0]);
                int sum = 0;
                for (int num : nums) {
                    int curr = Math.abs(num);
                    sum += curr;
                    min = Math.min(min, curr);
                }

                if (((k - negCount) & 1) == 1) {
                    return sum - 2 * min;
                }
                return sum;
            } else {
                // 那么我们把负得最多的几个转过来
                int sum = 0;
                var pq = new PriorityQueue<Integer>();
                for (int num : nums) {
                    if (num >= 0) {
                        sum += num;
                    } else {
                        sum -= num;
                        pq.offer(num);
                        if (pq.size() > negCount - k) {
                            pq.poll();
                        }
                    }
                }
                int t = 0;
                while (!pq.isEmpty()) {
                    t -= pq.poll();
                }
                return sum - 2 * t;
            }
        }
    }
}
