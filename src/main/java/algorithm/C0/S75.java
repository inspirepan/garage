package algorithm.C0;

/**
 * @author panjx
 */
public class S75 {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        while (i <= blue) {
            if (nums[i] == 0) {
                nums[i] = nums[red];
                nums[red++] = 0;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[blue];
                nums[blue--] = 2;
            } else {
                i++;
            }
        }
    }
}
