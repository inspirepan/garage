package algorithm.f1;

public class S53II {
    public int missingNumber(int[] nums) {
        int left = 0;
        int len = nums.length;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // left是第一个nums[left]!=left的，或者是len-1最后一个
        return left == len - 1 && nums[left] == left ? left + 1 : left;
    }
}
