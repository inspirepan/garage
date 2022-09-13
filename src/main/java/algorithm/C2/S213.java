package algorithm.C2;

import java.util.Arrays;

public class S213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] f = new int[len];
        f[1] = nums[0];
        for (int i = 1; i < len - 1; i++) {
            f[i + 1] = Math.max(f[i], f[i - 1] + nums[i]);
        }
        int temp1 = f[len - 1];

        Arrays.fill(f, 0);
        f[1] = nums[1];
        for (int i = 2; i < len; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return Math.max(temp1, f[len - 1]);
    }
}
