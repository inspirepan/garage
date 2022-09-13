package algorithm.c14;

public class S1437 {
    public boolean kLengthApart(int[] nums, int k) {
        // 注意边界问题
        int count = 0;
        int start = 0;
        while (start < nums.length && nums[start] == 0) {
            start++;
        }
        int end = nums.length - 1;
        while (end >= 0 && nums[end] == 0) {
            end--;
        }
        if (end <= start) {
            return true;
        }
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] == 1) {
                if (count < k) {
                    return false;
                }
                count = 0;
            } else {
                count++;
            }
        }
        return true;
    }
}
