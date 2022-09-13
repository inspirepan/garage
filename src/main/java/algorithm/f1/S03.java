package algorithm.f1;

public class S03 {
    public int findRepeatNumber(int[] nums) {
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (hasZero) {
                    return 0;
                }
                hasZero = true;
                continue;
            }

            int t = Math.abs(nums[i]);
            if (nums[t] < 0) {
                return t;
            }
            nums[t] *= -1;
        }
        return 1;
    }
}
