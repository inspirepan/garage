package algorithm.c2;

public class S209 {
    /**
     * 果然双指针还是容易出错
     *
     * @param s    *
     * @param nums *
     * @return *
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 || s == 1) {
            return nums[0] >= s ? 1 : 0;
        }
        int p = -1, q = -1;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (q <= nums.length - 1) {
            System.out.println("sum" + sum);
            if (sum < s && q < nums.length - 1) {
                sum += nums[++q];
            } else if (sum >= s) {
                len = Math.min(len, q - p);
                if (len == 1) {
                    return 1;
                }
                sum -= nums[++p];
            } else {
                break;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static int minSubArrayLen2(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= s ? 1 : 0;
        }
        int p = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for (int q = 0; q < nums.length; q++) {
            sum += nums[q];
            while (sum >= s) {
                len = Math.min(len, p - q + 1);
                sum -= nums[p++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
