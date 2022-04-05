package algorithm.C1;

public class S162 {
    public int findpeakelement(int[] nums) {
        // 有点难，怎么用二分呢，
        // 其实这道题就是要用二分找一个局部最大值
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
