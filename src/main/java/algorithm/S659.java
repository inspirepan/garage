package algorithm;

import java.util.Arrays;

public class S659 {
    public boolean isPossible(int[] nums) {
        if (nums.length == 0) return false;
        int size = nums[nums.length - 1] - nums[0] + 1;
        int[] count = new int[size];
        for (int num : nums) {
            count[num - nums[0]]++;
        }
        int i = 0;
        while (i < count.length - 2) {
            System.out.println(Arrays.toString(count));
            int j = i + 1;
            while (j < count.length && count[j] >= count[i]) {
                count[j] -= count[i];
                j++;
            }
            if (j < i + 2) return false;
            count[i] = 0;
            i++;
        }

        for (int k : count) {
            if (k > 0) return false;
        }
        return true;
    }
}
