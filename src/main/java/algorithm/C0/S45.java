package algorithm.C0;

public class S45 {
    public int jump(int[] nums) {
        int end = 0;
        int available = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            available = Math.max(available, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = available;
                steps++;
            }
        }
        return steps;
    }
}