package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S912 {
    class Solution {
        public int[] sortArray(int[] nums) {
            quicksort(nums, 0, nums.length);
            return nums;
        }

        void quicksort(int[] A, int left, int right) {
            if (left < right) {
                int p = partition(A, left, right);
                quicksort(A, left, p - 1);
                quicksort(A, p + 1, right);
            }
        }

        int partition(int[] A, int left, int right) {
            int k = A[left];
            while (left < right) {
                while (left < right && A[right] >= k) {
                    right--;
                }
                A[left] = A[right];
                while (left < right && A[left] <= k) {
                    left++;
                }
                A[right] = A[left];
            }
            A[left] = k;
            return left;
        }
    }
}
