package algorithm;

public class Sort {

    public static void QuickSort(int[] nums) {
        QSort(nums, 0, nums.length - 1);
    }

    public static void QSort(int[] nums, int low, int high) {
        // System.out.println("QS= " + Arrays.toString(nums));
        if (low < high) {
            int pivot_loc = Partition(nums, low, high);
            QSort(nums, low, pivot_loc - 1);
            QSort(nums, pivot_loc + 1, high);

        }
    }

    public static int Partition(int[] nums, int low, int high) {
        int t = nums[low];
        // System.out.println("temp= " + t);
        while (low < high) {
            while (low < high && nums[high] >= t)
                --high;
            nums[low] = nums[high];
            // System.out.println("temp1= " + Arrays.toString(nums));
            while (high > low && nums[low] <= t)
                ++low;
            nums[high] = nums[low];
            // System.out.println("temp2= " + Arrays.toString(nums));
        }
        nums[low] = t;
        // System.out.println("par= " + low);
        // System.out.println("numsAfterPar= " + Arrays.toString(nums));
        return low;

    }
}
