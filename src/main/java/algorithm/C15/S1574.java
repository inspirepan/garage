package algorithm.C15;

import java.util.Arrays;

public class S1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        //判断左边递增左右边界 以及右边
        // 算法我已经想出来了，就是没想到二分搜索，我想的统计两边的各种大小的位置，分别放在两个数组里，然后拿一条水平线去划大小，但是这样子没法找到"第一个大于"某个值的值，
        int left = 0, right = arr.length - 1;
        while (left + 1 < arr.length && arr[left + 1] >= arr[left]) {
            left++;
        }
        while (right - 1 >= 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        if (right == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= left; i++) {
            int p = binarySearch(arr, right, arr[i]);
            ans = Math.min(p - i - 1, ans);
        }
        return Math.min(ans, Math.min(arr.length - left, right));
    }

    public int binarySearch(int[] arr, int begin, int target) {
        // begin开始的刚刚大于target的数
        int left = begin, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target && (mid - 1 < begin || arr[mid - 1] < target)) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr.length;
    }
}
