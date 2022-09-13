package algorithm.c1;

import java.util.Arrays;

public class S164 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buffer = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] count = new int[10];
            // 统计当前位的数据
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                count[digit]++;
            }
            // 累加
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            // 按照当前位的数字排序、填入buffer
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buffer[count[digit] - 1] = nums[i];
                count[digit]--;
            }
            System.arraycopy(buffer, 0, nums, 0, n);
            exp *= 10;
        }
        // 已经将nums排序好
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
