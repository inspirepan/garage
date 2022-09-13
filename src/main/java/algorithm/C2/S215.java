package algorithm.C2;

import java.util.PriorityQueue;

/**
 * @author panjx
 */
public class S215 {
    // 快排优化
    public int findKthLargest1(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    private void quicksort(int[] nums, int low, int high, int k) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            // part正好是第k大的元素的位置
            if (pivot == nums.length - k) {
                return;
            }
            // 只排序一边
            if (pivot < nums.length - k) {
                quicksort(nums, pivot + 1, high, k);
            } else {
                quicksort(nums, low, pivot - 1, k);
            }
        }
    }

    private int partition(int[] nums, int l, int r) {
        int t = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= t) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= t) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = t;
        return l;
    }

    // 堆比quicksort更快啊
    private int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            if (pq.size() < k) {
                pq.offer(n);
            } else {
                if (pq.peek() < n) {
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        return pq.poll();
    }
}
