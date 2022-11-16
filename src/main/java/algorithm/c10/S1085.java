package algorithm.c10;

public class S1085 {
    public int sumOfDigits(int[] nums) {
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        return (sum & 1) ^ 1;
    }
}
