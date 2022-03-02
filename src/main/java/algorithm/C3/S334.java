package algorithm.C3;

import java.util.ArrayDeque;
import java.util.Deque;

public class S334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int max = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= max) {
                max = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
