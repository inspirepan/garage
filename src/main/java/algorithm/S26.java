package algorithm;

public class S26 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int mark = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mark) {
                i++;
            } else {
                mark = nums[i];
                nums[j] = mark;
                j++;
            }
        }
        return j;
    }
}
