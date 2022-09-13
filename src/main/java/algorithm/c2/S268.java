package algorithm.c2;

public class S268 {
    public int missingNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= i;
            x ^= nums[i];
        }
        x ^= nums.length;
        return x;
    }
}
