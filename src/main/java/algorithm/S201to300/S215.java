package algorithm.S201to300;

import java.util.Random;

/**
 * @author panjx
 */
public class S215 {
    /**
     * 优化快排 10ms （未优化快排 48s）
     */
    public int findKthLargest2(int[] nums, int k) {
        qSort(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    private void qSort(int[] nums, int low, int high, int k) {
        if (low < high) {
            int part = partition(nums, low, high);
            // part正好是第k大的元素的位置
            if (part == nums.length - k) {
                return;
            }
            // 继续排序包含第k大的元素的那一边
            if (part < nums.length - k) {
                qSort(nums, part + 1, high, k);
            } else {
                qSort(nums, low, part - 1, k);
            }
        }
    }

    private int partition(int[] nums, int low, int high) {
        int t = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= t) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= t) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = t;
        return low;
    }

    /**
     * 随机快排 2ms
     */
    public int findKthLargest3(int[] nums, int k) {
        qSort2(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    private void qSort2(int[] nums, int low, int high, int k) {
        if (low < high) {
            int part = randomPartition(nums, low, high);
            if (part == nums.length - k) {
                return;
            }
            if (part < nums.length - k) {
                qSort2(nums, part + 1, high, k);
            } else {
                qSort2(nums, low, part - 1, k);
            }
        }
    }

    private static int randomPartition(int[] nums, int low, int high) {
        int i = new Random().nextInt(high - low + 1) + low;
        swap(nums, i, low);
        return partition2(nums, low, high);
    }

    private static int partition2(int[] nums, int low, int high) {
        int t = nums[low];
        int h = high;
        for (int j = high; j >= 0; j--) {
            if (nums[j] > t) {
                swap(nums, j, h--);
            }
        }
        swap(nums, low, h);
        return h;
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }


    /**
     * 冒泡 24ms
     */
    public int findKthLargest(int[] nums, int k) {
        if (k < nums.length / 2) {
            for (int i = 0; i < k; i++) {
                for (int j = 1; j < nums.length - i; j++) {
                    if (nums[j] < nums[j - 1]) {
                        int t = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = t;
                    }
                }
            }
            return nums[nums.length - k];
        } else {
            for (int i = 0; i < nums.length - k + 1; i++) {
                for (int j = 1; j < nums.length - i; j++) {
                    if (nums[j] > nums[j - 1]) {
                        int t = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = t;
                    }
                }
            }
            return nums[k - 1];
        }
    }
}
