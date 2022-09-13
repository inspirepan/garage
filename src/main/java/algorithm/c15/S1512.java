package algorithm.c15;

public class S1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            if (count[i] > 1) {
                result += C2(count[i]);
            }
        }
        return result;
    }

    // 排列组合公式都快忘了
    private int C2(int i) {
        return i * (i - 1) / 2;
    }
}
