package algorithm;

public class S905 {
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                while (left < right && (nums[left] & 1) == 0) {
                    left++;
                }
                while (right > left && (nums[right] & 1) == 1) {
                    right--;
                }
                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }
            return nums;
        }
    }
}
