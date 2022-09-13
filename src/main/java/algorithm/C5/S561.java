package algorithm.C5;

import java.util.Arrays;

public class S561 {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
