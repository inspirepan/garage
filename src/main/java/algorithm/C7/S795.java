package algorithm.C7;

public class S795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 大于right的元素就是分隔
        // 子数组必须包含至少一个大于等于left的元素
        int p = 0;
        int start = 0;  // 上一个大于right的元素的右边第一个元素
        int count = 0;
        int lastAvailable = -1; // 上一个大于等于left的元素位置
        while (p < nums.length) {
            // p是从0到len-1，遍历一遍nums数组，
            // 每一次考虑的是以nums[p]结尾的子数组的数量，
            // 每次count加的是允许的子数组开始的范围
            // 子数组中不应该有大于right的元素
            if (nums[p] > right) {
                start = ++p;
            } else {
                if (nums[p] >= left) {
                    lastAvailable = p;
                }
                if (lastAvailable >= start) {
                    count += lastAvailable - start + 1;
                }
                p++;
            }
        }
        return count;
    }
}
