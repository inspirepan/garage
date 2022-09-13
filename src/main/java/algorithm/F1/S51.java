package algorithm.F1;

public class S51 {
    class Solution {
        int[] temp;

        // 自己写的归并排序的版本，注意不要重复创建temp数组
        public int reversePairs(int[] nums) {
            int[] copy = new int[nums.length];
            this.temp = new int[nums.length];
            System.arraycopy(nums, 0, copy, 0, nums.length);
            return mergeSort(copy, 0, nums.length - 1);
        }

        int mergeSort(int[] nums, int start, int end) {
            if (start >= end) {
                return 0;
            }
            int mid = start + (end - start) / 2;
            int leftPair = mergeSort(nums, start, mid);
            int rightPair = mergeSort(nums, mid + 1, end);
            if (nums[mid] < nums[mid + 1]) {
                return leftPair + rightPair;
            }
            System.arraycopy(nums, start, temp, start, end - start + 1);
            int left = start;
            int right = mid + 1;
            int index = start;
            int pair = 0;
            while (index <= end) {
                if (left > mid) {
                    nums[index] = temp[right++];
                } else if (right > end) {
                    nums[index] = temp[left++];
                } else if (temp[left] <= temp[right]) {
                    nums[index] = temp[left++];
                } else {
                    nums[index] = temp[right++];
                    pair += mid + 1 - left;
                }
                index++;
            }
            return leftPair + rightPair + pair;
        }
    }
}