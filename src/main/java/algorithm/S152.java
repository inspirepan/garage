package algorithm;

public class S152 {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * num, num); // 这一步是考虑0的情况
            min = Math.min(min * num, num);
            result = Math.max(max, result);
        }
        return result;
    }
}
