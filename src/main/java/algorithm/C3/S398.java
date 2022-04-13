package algorithm.C3;

import java.util.*;

public class S398 {
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                var list = map.getOrDefault(nums[i], new ArrayList<>());
                list.add(i);
                map.put(nums[i], list);
            }
        }

        public int pick(int target) {

            var list = map.get(target);
            Random random = new Random();
            int r = random.nextInt(list.size());
            return list.get(r);
        }
    }

    class Solution2 {

        int[] arr;
        // 蓄水池抽样

        public Solution2(int[] nums) {
            this.arr = nums;
        }

        public int pick(int target) {
            Random random = new Random();
            int count = 0;
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    count++;
                    if (random.nextInt(count) == 0) res = i;
                }
            }
            return res;
        }
    }
}
