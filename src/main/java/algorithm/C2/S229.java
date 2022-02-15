package algorithm.C2;

import java.util.ArrayList;
import java.util.List;

/**
 * 摩尔投票
 * 求出现次数大于n/3的数，最多2个
 */
public class S229 {
    public List<Integer> majorityElement(int[] nums) {
        // 出现次数最多
        int n1 = 0, n2 = 0;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            // 更换备选
            if (count1 == 0 && num != n2) {
                n1 = num;
            }
            if (count2 == 0 && num != n1) {
                n2 = num;
            }
            // 修改count
            if (n1 == num) {
                count1++;
            } else if (n2 == num) {
                count2++;
            } else {
                if (count1 > 0) {
                    count1--;
                }
                if (count2 > 0) {
                    count2--;
                }
            }
        }
        // 还要重新计算一次出现次数
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (n1 == num) {
                ++count1;
            } else if (n2 == num) {
                ++count2;
            }
        }
        List<Integer> arr = new ArrayList<>();
        if (count1 > nums.length / 3) {
            arr.add(n1);
        }
        if (count2 > nums.length / 3) {
            arr.add(n2);
        }
        return arr;
    }
}
