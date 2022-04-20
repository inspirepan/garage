package algorithm.C0;

public class S41 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 只能用原地
            // 123456
            // 654237
            // 723456
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (nums[i] > len || nums[i] <= 0) {
                    continue;
                }
                // 每个位置i的数应该是i+1
                if (nums[i] == i + 1) {
                    continue;
                }
                while (nums[i] >= 1 && nums[i] <= len) {
                    // 如果i或者nums[i]-1的位置已经是正确的数，就不管了
                    if (nums[i] == i + 1 || nums[nums[i] - 1] == nums[i]) break;
                    swap(nums, i, nums[i] - 1);
                }
            }
            for (int i = 0; i < len; i++) {
                if (nums[i] != i + 1) return i + 1;
            }
            return len + 1;
        }

        void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
