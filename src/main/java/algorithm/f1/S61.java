package algorithm.f1;

import java.util.Arrays;

public class S61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        // 0的数量
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        // 4个以上的0
        if (i >= 4) {
            return true;
        }
        // 0之后重复的
        int p = i;
        while (p < 4) {
            if (nums[p] == nums[p + 1]) {
                return false;
            }
            p++;
        }
        return nums[4] - nums[i] <= 4;
    }
}
