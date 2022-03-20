package algorithm.C6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S697 {
    public int findShortestSubArray(int[] nums) {
        // 统计出现次数最多的元素
        // 出现次数元素的左右界
        // 可以改成数组提速，懒得弄了
        if (nums.length == 1) return 1;
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 1;
        List<Integer> maxNum = new ArrayList<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            if (count > maxCount) {
                maxNum.clear();
                maxNum.add(n);
                maxCount = count;
            } else if (count == maxCount) {
                maxNum.add(n);
            }
            map.put(n, count);
        }
        // 对于maxNum中的每一个数，记录最左最右出现的位置，可以用两个Map一次遍历的，懒得弄了
        if (maxCount == 1) return 1;
        int result = nums.length;
        for (int c : maxNum) {
            int left = 0;
            int right = nums.length - 1;
            while (left < nums.length && nums[left] != c) left++;
            while (right >= 0 && nums[right] != c) right--;
            result = Math.min(result, right - left + 1);
        }
        return result;
    }
}
