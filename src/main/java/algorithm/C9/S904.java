package algorithm.C9;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author : panjixiang
 * @since : 2022/9/13
 */
public class S904 {
    class Solution {
        public int totalFruit(int[] fruits) {
            var last = new HashMap<Integer, Integer>();
            var set = new HashSet<Integer>();
            int left = 0;
            int right = 0;
            int max = 0;
            int len = fruits.length;
            while (right < len) {
                int curr = fruits[right];
                if (set.size() < 2) {
                    set.add(curr);
                } else if (!set.contains(curr)) {
                    int minLeft = right;
                    int minValue = curr;
                    for (int key : set) {
                        if (minLeft > last.get(key)) {
                            minLeft = last.get(key);
                            minValue = key;
                        }
                    }
                    left = minLeft + 1;
                    set.remove(minValue);
                    set.add(curr);
                }
                max = Math.max(max, right - left + 1);
                last.put(curr, right++);
            }
            return max;
        }
    }
}
