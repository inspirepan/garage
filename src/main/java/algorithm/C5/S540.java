package algorithm.C5;

public class S540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prev1 = nums[0];
        int prev2 = nums[1];
        if (prev1 != prev2) {
            return nums[2] == prev2 ? prev1 : prev2;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == prev2) {
                prev1 = prev2;
                prev2 = nums[i];
            } else if (prev2 != prev1) {
                // 连续三个不一样的
                return prev2;
            } else {
                prev1 = prev2;
                prev2 = nums[i];
            }
        }
        return prev2;
    }

    public int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

}
