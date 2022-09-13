package algorithm.C7;

public class S724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curr * 2 + nums[i] == sum) {
                return i;
            }
            curr += nums[i];
        }
        return -1;
    }
}
