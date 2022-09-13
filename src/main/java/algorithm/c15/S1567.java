package algorithm.c15;

public class S1567 {
    public int getMaxLen(int[] nums) {
        // 负数个数是偶数个
        // 统计负数的个数，如果是偶数，那么就是数组长度
        // 如果是奇数，那么删掉左侧或者右侧的第一个负数那一截
        // 还有0的情况，0也是一个截断
        int maxLen = 0, left = 0, right = 0, negaCount = 0, firstNega = 0, LastNega = 0;
        while (right <= nums.length) {
            if (nums.length == right || nums[right] == 0) {
                if ((negaCount & 1) == 0) {
                    // [left, right-1]
                    maxLen = Math.max(maxLen, right - left);
                } else {
                    // [firstNega+1, right-1]和[left, LastNega-1]
                    maxLen = Math.max(maxLen, Math.max(right - firstNega - 1, LastNega - left));
                }
                left = ++right;
                negaCount = 0;
            } else {
                if (nums[right] < 0) {
                    if (++negaCount == 1) {
                        firstNega = right;
                    }
                    LastNega = right;
                }
                right++;
            }
        }
        return maxLen;
    }
}
