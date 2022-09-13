package algorithm.C4;

import java.util.ArrayList;
import java.util.List;

public class S442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curNum = Math.abs(nums[i]);
            if (nums[curNum - 1] < 0) {
                ans.add(curNum);
            }
            nums[curNum - 1] *= (-1);
        }
        return ans;
    }
}
