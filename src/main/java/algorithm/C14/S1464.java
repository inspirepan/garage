package algorithm.C14;

public class S1464 {
    public int maxProduct(int[] nums) {
        // 不是很懂，就是找两个最大值呗
        if (nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int second = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second) {
                second = num;
            }
        }
        return (max - 1) * (second - 1);
    }
}
