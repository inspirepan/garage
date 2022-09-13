package algorithm.C4;

public class S453 {
    public int minMoves(int[] nums) {
        // n-1元素+1相当于1一个元素-1吗
        if (nums.length <= 1) {
            return 0;
        }
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int count = 0;
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }
}
