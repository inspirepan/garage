package algorithm.c9;

import java.util.ArrayDeque;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S945 {
    class Solution {
        public int minIncrementForUnique(int[] nums) {
            int[] count = new int[100001];
            for (int num : nums) {
                count[num]++;
            }
            int res = 0;
            var queue = new ArrayDeque<Integer>();
            for (int i = 0; i < 100001; i++) {
                if (count[i] > 1) {
                    for (int j = 0; j < count[i] - 1; j++) {
                        queue.offer(i);
                    }
                }
                if (count[i] == 0 && !queue.isEmpty()) {
                    res += i - queue.poll();
                }
            }
            int k = 100001;
            while (!queue.isEmpty()) {
                res += k++ - queue.poll();
            }
            return res;
        }
    }
}
