package algorithm.c9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : panjixiang
 * @since : 2022/9/19
 */
public class S962 {
    class Solution {
        public int maxWidthRamp(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int res = 0;
            // 单调列表
            for (int i = 0; i < nums.length; i++) {
                if (!list.isEmpty() && nums[i] >= nums[list.get(list.size() - 1)]) {
                    int left = 0;
                    int right = list.size();
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (nums[list.get(mid)] <= nums[i]) {
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    }
                    res = Math.max(res, i - list.get(left));
                } else {
                    list.add(i);
                }
            }
            return res;
        }
    }
}
