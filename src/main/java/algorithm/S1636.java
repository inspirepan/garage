package algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : panjixiang
 * @since : 2022/9/19
 */
public class S1636 {
    class Solution {
        public int[] frequencySort(int[] nums) {
            int[] count = new int[201];
            for (int num : nums) {
                count[num + 100]++;
            }

            ArrayList<Integer>[] r = new ArrayList[101];
            for (int i = 0; i < count.length; i++) {
                int n = i - 100;
                if (r[count[i]] == null) {
                    r[count[i]] = new ArrayList<Integer>();
                }
                r[count[i]].add(n);
            }
            int[] res = new int[nums.length];
            int i = 0;
            for (int k = 0; k < r.length; k++) {
                if (r[k] != null) {
                    Collections.sort(r[k]);
                    for (int m = r[k].size() - 1; m >= 0; m--) {
                        for (int i1 = 0; i1 < k; i1++) {
                            res[i++] = r[k].get(m);
                        }
                    }
                }
            }
            return res;
        }
    }
}
