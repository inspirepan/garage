package algorithm.c4;

public class S487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // 滑动窗口，窗口里面最多一个0
        int max = 0;
        int left = 0;
        int right = 0;
        int zero = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (zero == 0) {
                    // 包含这个零
                    max = Math.max(max, right - left + 1);
                    right++;
                    zero = 1;
                } else {
                    // left左缩
                    while (left < right && nums[left] != 0) {
                        left++;
                    }
                    left++;
                    zero = 0;
                }
            } else {
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        return max;
    }
}
