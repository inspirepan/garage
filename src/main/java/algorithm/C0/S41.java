package algorithm.C0;

public class S41 {
    /**
     * 第一个想法是桶排序
     * 但是空间复杂度要求是常数，说明要数组内原地交换
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int[] bucket = new int[nums.length + 1];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                bucket[num] = 1;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (bucket[i] != 1) {
                return i;
            }
        }
        return nums.length + 1;
    }

    /**
     * 交换做法
     */
    public int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            relocate(nums, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void relocate(int[] nums, int i) {
        if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length) {
            // 如果a已经在第a的位置上了，说明重复了，跳过
            if (nums[nums[i] - 1] == nums[i]) {
                return;
            }
            swap(nums, i, nums[i] - 1);
            relocate(nums, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
