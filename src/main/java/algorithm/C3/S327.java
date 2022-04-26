package algorithm.C3;

import java.util.*;

public class S327 {
    class Solution {
        // 算出前缀和
        // 要么就是每个前缀和在low到up的范围内，表示0,n这段区间符合要求 情况1
        // 要么就是两个前缀和之间的差在low到up的范围内，这一部分用归并排序的简化计算
        int count = 0;
        public int countRangeSum(int[] nums, int lower, int upper) {

            int n = nums.length;
            long[] pres = new long[n];
            pres[0] = nums[0];
            for(int i = 1; i < n; i++) pres[i] = pres[i - 1] + nums[i];
            mergeSort(pres, 0, n, lower, upper);
            return count;
        }
        public long[] mergeSort(long[] pres, int left, int right, int lower, int upper){

            if(left == right) return new long[0];
            if(right - left == 1){

                long last = pres[left];
                if(last >= lower && last <= upper) count++; // 情况1
                return new long[]{last};
            }

            int mid = (left + right) / 2;
            long[] ls = mergeSort(pres, left, mid, lower, upper);
            int ln = ls.length;
            long[] rs = mergeSort(pres, mid, right, lower, upper);
            int rn = rs.length;

            int cn = ln + rn;
            long[] copy = new long[cn];

            int l = 0, r1 = 0, r2 = 0;
            while(l < ln && r1 < rn){

                while(r1 < rn && rs[r1] < lower + ls[l]) r1++;
                r2 = r1 > r2 ? r1 : r2;
                while(r2 < rn && rs[r2] <= upper + ls[l]) r2++;
                count += r2 - r1;
                l++;
            }
            int p = 0;
            l = r1 = 0;
            while(p < cn){

                if(l < ln && (r1 >= rn || ls[l] < rs[r1])) copy[p++] = ls[l++];
                else copy[p++] = rs[r1++];
            }
            return copy;
        }
    }


}
