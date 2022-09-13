package algorithm.c0;

class S4 {
    class Solution {
        int[] nums1;
        int[] nums2;

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            this.nums1 = nums1;
            this.nums2 = nums2;
            int n = nums2.length;
            if (((m + n) & 1) == 1) {
                return find(0, 0, (m + n) / 2 + 1);
            } else {
                return ((double) find(0, 0, (m + n) / 2) + (double) find(0, 0, (m + n) / 2 + 1)) / 2;
            }
        }

        int find(int a, int b, int index) {
            // index要从1开始计数，从0开始计数 index-index/2这一步会出错
            if (a >= nums1.length) {
                return nums2[b + index - 1];
            }
            if (b >= nums2.length) {
                return nums1[a + index - 1];
            }
            if (index == 1) {
                return Math.min(nums1[a], nums2[b]);
            }

            int mid1 = a + index / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[a + index / 2 - 1];
            int mid2 = b + index / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[b + index / 2 - 1];
            if (mid1 < mid2) {
                return find(a + index / 2, b, index - index / 2);
            } else {
                return find(a, b + index / 2, index - index / 2);
            }
        }
    }
}