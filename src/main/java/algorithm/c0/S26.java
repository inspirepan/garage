package algorithm.c0;

public class S26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        while (i < len) {
            nums[j] = nums[i];
            j++;
            i++;
            while (i < len && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return j;
    }
}