package algorithm;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] d = new int[]{2, 0, 1};
        new S75().sortColors(d);
        System.out.println(Arrays.toString(d));
    }
}
