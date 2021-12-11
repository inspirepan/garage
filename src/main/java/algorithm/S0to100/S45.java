package algorithm.S0to100;

public class S45 {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (len == 0 || nums[0] == 0) {
            return -1;
        }
        for (int i = 0; i < len - 1; i++) {
            nums[i] += i;
        }
        int time = 0;
        int target = len - 1;
        while (target > 0) {
            int prevTarget = target;
            for (int j = target - 1; j >= 0; j--) {
                if (nums[j] >= prevTarget) {
                    target = j;
                }
            }
            if (target == prevTarget) {
                return -1;
            }
            time++;
        }
        return time;
    }
}
