package algorithm.c6;

public class S659 {
    public boolean isPossible(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        // 记录数字频率
        int size = nums[nums.length - 1] - nums[0] + 1;
        int[] count = new int[size];
        for (int num : nums) {
            count[num - nums[0]]++;
        }
        int i = 0;
        while (i < count.length - 2) {
            // 考虑每一个数，往后贪心，必须要消除掉
            int j = i + 1;
            // 后面的数count大于i，就可以消除
            while (j < count.length && count[j] >= count[i]) {
                count[j] -= count[i];
                j++;
            }
            // 如果数量不足3个，说明会有i剩余，false
            if (j < i + 2) {
                return false;
            }
            count[i] = 0;
            i++;
        }
        // 剩余的数量
        for (int k : count) {
            if (k > 0) {
                return false;
            }
        }
        return true;
    }
}
