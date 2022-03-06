package algorithm.C4;

import java.util.ArrayList;
import java.util.List;

public class S448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 将出现过的数字对应的索引标记成负数
            int k = Math.abs(nums[i]) - 1;
            if (nums[k] > 0) nums[k] = -nums[k];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}
