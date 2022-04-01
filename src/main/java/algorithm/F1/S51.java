package algorithm.F1;

public class S51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        // 使用归并排序
        int i = left; // 左边的指针
        int j = mid + 1; // 右边的指针

        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                // 如果左边已经全部比较完
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                // 右边已经全部比较完毕
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 左边的小于右边的

                nums[k] = temp[i];
                i++;
            } else {
                // 右边的小于左边的，交换
                nums[k] = temp[j];
                j++;
                // 在i到mid这一部分都是大于j的，计数
                // 注意左半部分和右半部分都是已经通过递归排好序的
                count += (mid - i + 1);
            }
        }
        return count;
    }
}