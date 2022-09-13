package algorithm.c4;

import java.util.Comparator;
import java.util.TreeSet;

public class S414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() >= 3) {
            set.pollFirst();
            set.pollFirst();
            return set.first();
        } else {
            return set.first();
        }
    }

    public int thirdMax2(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }
}
