package algorithm;

public class S1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 有nums[i]的范围就可以用桶排序
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }
        int less = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = less;
            less += temp;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[nums[i]];
        }
        return nums;
    }
}
