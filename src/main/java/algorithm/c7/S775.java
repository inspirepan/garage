package algorithm.c7;

public class S775 {
    public boolean isIdealPermutation(int[] nums) {
        // 这道题本身比较简单，不需要计算出到底有多少全局倒置
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (max > nums[i]) {
                return false;
            }
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}
