package algorithm.c14;

public class S1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n << 1];
        for (int i = 0; i < n; i++) {
            result[i << 1] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            result[(i << 1) + 1] = nums[i + n];
        }
        return result;
    }
}
