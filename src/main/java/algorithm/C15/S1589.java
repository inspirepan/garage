package algorithm.C15;

import java.util.Arrays;

public class S1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] counts = new int[nums.length];
        for (int[] r : requests) {
            counts[r[0]]++;
            if (r[1] != (nums.length - 1)) {
                counts[r[1] + 1]--;
            }
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i - 1] + counts[i];
        }
        Arrays.sort(counts);
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += (long) nums[i] * counts[i];
        }
        return (int) (res % 1_000_000_007);
    }
}
