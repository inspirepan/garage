package algorithm.C3;

import java.util.ArrayList;
import java.util.List;

public class S315merge {

    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int len = nums.length;
            int[] res = new int[len];
            int[] index = new int[len];
            int[] temp = new int[len];
            // index数组排序，充当了一个数值->索引的Map功能
            for (int i = 0; i < len; i++) {
                index[i] = i;
            }

            mergeSort(nums, index, res, temp, 0, len - 1);
            List<Integer> list = new ArrayList<>();
            // 转换res
            for (int i = 0; i < len; i++) {
                list.add(res[i]);
            }
            return list;
        }

        void mergeSort(int[] nums, int[] index, int[] res, int[] temp, int left, int right) {
            if (left == right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeSort(nums, index, res, temp, left, mid);
            mergeSort(nums, index, res, temp, mid + 1, right);

            if (nums[index[mid]] <= nums[index[mid + 1]]) {
                return;
            }

            for (int k = left; k <= right; k++) {
                temp[k] = index[k];
            }

            int i = left;
            int j = mid + 1;
            for (int k = left; k <= right; k++) {
                if (i == mid + 1) {
                    index[k] = temp[j];
                    j++;
                } else if (j == right + 1) {
                    index[k] = temp[i];
                    i++;
                    res[index[k]] += right - mid;
                } else if (nums[temp[i]] > nums[temp[j]]) {
                    index[k] = temp[j];
                    j++;
                } else {
                    index[k] = temp[i];
                    i++;
                    res[index[k]] += j - mid - 1;
                }
            }
        }
    }
}
