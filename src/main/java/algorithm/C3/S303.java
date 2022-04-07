package algorithm.C3;

public class S303 {
    class NumArray {

        int[] sum;

        public NumArray(int[] nums) {
            int len = nums.length;
            sum = new int[len + 1];

            int s = 0;
            int i = 0;
            for (int n : nums) {
                s += n;
                sum[++i] = s;
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }
}
