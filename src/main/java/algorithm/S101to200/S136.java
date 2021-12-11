package algorithm.S101to200;

import java.util.Arrays;

public class S136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            } else {
                i++;
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
