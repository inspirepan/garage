package algorithm;

import java.util.Random;

public class Sort {

    /**
     * 快排，O(n*logn)
     */
    public static void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private static void quickSortHelper(int[] nums, int low, int high) {
        if (low < high) {
            int pivotLoc = partition(nums, low, high);
            quickSortHelper(nums, low, pivotLoc - 1);
            quickSortHelper(nums, pivotLoc + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        // 用第一个数t作为分界标志，t左边的都是小于t的，t右边的全部是大于t的
        int t = nums[low];
        // 每次low和high向中间缩，找到第一个大于/小于的，然后交换位置，继续往中间缩
        while (low < high) {
            // high：右边起第一个小于t的
            while (low < high && nums[high] >= t) {
                --high;
            }
            // 最左边放上刚刚找到的第一个小于t的
            nums[low] = nums[high];
            // 左边起第一个大于t的
            while (high > low && nums[low] <= t) {
                ++low;
            }
            // high的地方放上刚刚找到的第一个大于t的
            nums[high] = nums[low];
            // 这个时候，high右边全部是大于t的，low左边全部是小于t的
        }
        // 当high==low的时候，就代表分边界已经完成了
        nums[low] = t;
        return low;
    }

    /**
     * 随机快排
     */
    private static void randomQuickSortHelper(int[] nums, int low, int high) {
        if (low < high) {
            int pivotLoc = randomPartition(nums, low, high);
            quickSortHelper(nums, low, pivotLoc - 1);
            quickSortHelper(nums, pivotLoc + 1, high);
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
     * 冒泡排序，O(n^2)
     *
     * @param nums 数组
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int t = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = t;
                }
            }
        }
    }

    /**
     * 选择排序，O(n^2)
     *
     * @param nums 数组
     */
    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int t = nums[i];
            nums[i] = min;
            nums[minIndex] = t;
        }
    }

    /**
     * 插入排序，O(n^2)
     * 外层遍历一遍
     * 每一个数往回找到自己的位置插入
     */
    public static void insertionSort(int[] nums) {
        int p = 1;
        while (p < nums.length) {
            if (nums[p] < nums[p - 1]) {
                int blank = p;
                int val = nums[blank];
                // blank 就是空位
                while (blank > 0 && nums[blank - 1] >= val) {
                    nums[blank] = nums[blank - 1];
                    blank--;
                }
                nums[blank] = val;
            }
            p++;
        }
    }

    public static void shellSort(int[] nums) {

    }

    /**
     * 归并排序，时间O(n*logn)，空间O(n)
     * 分成两半，递归排序好，然后再双指针排序合并。
     * 优化：当递归到长度小于一定大小时，换用其他排序方法比如插入排序。
     *
     * @param nums 输入
     */
    public static void mergeSort(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        mergeSortHelper(nums, copy, 0, nums.length - 1);
    }

    private static void mergeSortHelper(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSortHelper(nums, copy, start, mid);
        mergeSortHelper(nums, copy, mid + 1, end);
        int copyIndex = start;
        int i = start;
        int j = mid + 1;
        while (i < mid + 1 || j < end + 1) {
            // 到边界
            if (i == mid + 1) {
                copy[copyIndex++] = nums[j++];
            } else if (j == end + 1) {
                copy[copyIndex++] = nums[i++];
            }
            // 都未到边界，按大小判断
            else if (nums[i] > nums[j]) {
                copy[copyIndex++] = nums[j++];
            } else {
                copy[copyIndex++] = nums[i++];
            }
        }
        System.arraycopy(copy, start, nums, start, end - start + 1);
    }
}
