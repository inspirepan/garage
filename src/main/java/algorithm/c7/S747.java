package algorithm.c7;

public class S747 {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > max) {
                max = n;
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }
            if (nums[i] * 2 > max) {
                return -1;
            }
        }
        return index;
    }
}
