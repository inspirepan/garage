package algorithm.C14;

import java.lang.reflect.Array;
import java.util.Arrays;

public class S1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        // 二分查找，对于每一天，查看开花数是否满足m束花
        int right = 0;
        for (int num : bloomDay) {
            right = Math.max(right, num);
        }
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = count(bloomDay, mid, k);
            if (count >= m) {
                right = mid ;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int count(int[] nums, int day, int k) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= day) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                count = 0;
                res++;
            }
        }
        return res;
    }
}
