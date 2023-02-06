package algorithm.c0;

/**
 * 当前排列在全排列中的下一个
 * 12345
 * 12354
 * 12435
 * 12453
 * 12534
 * 12543
 * 13245
 * 13254
 * <p>
 * <p>
 * 134265
 * 134526
 * <p>
 * 1765432
 * 2765431
 * 2134567
 */

public class S31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到结尾往前出现的第一个升序i
        // 因为降序是不可能产生更大的排列的！
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 找到结尾往前第一个出现的比nums[i]大的
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            // 因为交换的两个数左边的比右边的小，因此交换之后i+1之后的部分仍然保持了倒序，此时reverse一遍即可
        }
        // 如果 i==0，翻转整个数组
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
