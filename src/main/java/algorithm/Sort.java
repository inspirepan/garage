package algorithm;

public class Sort {

    /**
     * 快排，O(n*logn)
     *
     * @param nums
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

        int t = nums[low];
        while (low < high) {
            /*
             分别操作三个值，low位置的初始值（即本次操作的部分最左侧的值），从最右往左第一个小于初始值的值，从左往右第一个大于初始值的值
             操作前：
             t ------------ firstHigher ******** firstLower ++++++
             一次操作后：
             firstLower --- firstHigher ******** firstHigher +++++
                             (low)              (high)
             -号处值小于t，+号处值大于t，*号处未判断
             继续迭代
            */
            while (low < high && nums[high] >= t) {
                --high;
            }
            nums[low] = nums[high];
            while (high > low && nums[low] <= t) {
                ++low;
            }
            nums[high] = nums[low];
        }
        nums[low] = t;
        return low;
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
     *
     * @param nums
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
            if (i == mid + 1) {
                copy[copyIndex++] = nums[j++];
            } else if (j == end + 1) {
                copy[copyIndex++] = nums[i++];
            } else if (nums[i] > nums[j]) {
                copy[copyIndex++] = nums[j++];
            } else {
                copy[copyIndex++] = nums[i++];
            }
        }
        System.arraycopy(copy, start, nums, start, end - start + 1);
    }


}
