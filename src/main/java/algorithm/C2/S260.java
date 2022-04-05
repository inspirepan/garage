package algorithm.C2;

public class S260 {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        // a ^ b = x;
        x = x & (-x);
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((x & n) > 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
