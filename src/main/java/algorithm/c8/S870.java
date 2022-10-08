package algorithm.c8;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/10/8
 */
public class S870 {
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            // 贪心，每个位置找大于nums2[i]的最小值，如果没有大于nums2[i]的，放一个nums1的最小值
            int len = nums1.length;
            // 保留nums2的index
            int[][] index = new int[len][2];
            for (int i = 0; i < len; i++) {
                index[i][0] = nums2[i];
                index[i][1] = i;
            }
            Arrays.sort(nums1);
            // nums2排序，大到小
            Arrays.sort(index, (a, b) -> b[0] - a[0]);
            int left = 0;
            int right = len - 1;
            for (int i = 0; i < len; i++) {
                if (nums1[right] > index[i][0]) {
                    nums2[index[i][1]] = nums1[right];
                    right--;
                } else {
                    nums2[index[i][1]] = nums1[left];
                    left++;
                }
            }
            return nums2;
        }
    }
}
