package algorithm;

public class Sort {

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

    public static void bubbleSort(int[] nums) {

    }

    public static void selectionSort(int[] nums) {

    }

    public static void shellSort(int[] nums) {

    }

    public static void mergeSort(int[] nums) {

    }

}
