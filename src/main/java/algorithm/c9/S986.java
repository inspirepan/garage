package algorithm.c9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : panjixiang
 * @since : 2022/11/3
 */
public class S986 {
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            int i = 0;
            int j = 0;
            List<int[]> res = new ArrayList<>();
            while (i < firstList.length && j < secondList.length) {
                int start1 = firstList[i][0];
                int end1 = firstList[i][1];
                int start2 = secondList[j][0];
                int end2 = secondList[j][1];
                if (start1 == start2) {
                    if (end1 == end2) {
                        res.add(new int[]{start1, end1});
                        ++j;
                        ++i;
                    } else if (end1 < end2) {
                        res.add(new int[]{start1, end1});
                        ++i;
                    } else {
                        res.add(new int[]{start2, end2});
                        ++j;
                    }
                } else if (start1 < start2) {
                    if (end1 < end2) {
                        if (start2 <= end1) {
                            res.add(new int[]{start2, end1});
                        }
                        i++;
                    } else if (end1 == end2) {
                        res.add(new int[]{start2, end1});
                        i++;
                        j++;
                    } else {
                        res.add(new int[]{start2, end2});
                        j++;
                    }
                } else {
                    if (end1 == end2) {
                        res.add(new int[]{start1, end1});
                        i++;
                        j++;
                    } else if (end1 < end2) {
                        res.add(new int[]{start1, end1});
                        i++;
                    } else {
                        if (end2 >= start1) {
                            res.add(new int[]{start1, end2});
                        }
                        j++;
                    }
                }
            }
            int[][] result = new int[res.size()][2];
            for (int k = 0; k < res.size(); k++) {
                result[k][0] = res.get(k)[0];
                result[k][1] = res.get(k)[1];
            }
            return result;
        }
    }
}
