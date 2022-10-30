package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/10/31
 */
public class S985 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int currEvenSum = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                currEvenSum += num;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int val = queries[i][1];
            boolean isEvenBefore = (nums[index] & 1) == 0;
            nums[index] += val;
            boolean isEvenAfter = (nums[index] & 1) == 0;
            if (isEvenAfter && isEvenBefore) {
                currEvenSum += val;
            } else if (isEvenAfter && !isEvenBefore) {
                currEvenSum += nums[index];
            } else if (isEvenBefore) {
                currEvenSum -= (nums[index] - val);
            }
            ans[i] = currEvenSum;
        }
        return ans;
    }
}
