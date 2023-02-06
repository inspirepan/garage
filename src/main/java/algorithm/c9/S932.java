package algorithm.c9;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S932 {

    class Solution {
        public int[] beautifulArray(int N) {
            // 可以理解为，任意两个索引之间，没有和这两个索引值"等距"的值

            int[] a = new int[N];
            Arrays.fill(a, 1);
            part(a, 0, N - 1);
            return a;
        }

        public void part(int[] a, int lo, int hi) {
            if (hi <= lo) {
                return;
            }
            int mid = lo + (hi - lo) / 2;
            part(a, lo, mid);
            part(a, mid + 1, hi);
            for (int i = lo; i <= mid; i++) {
                a[i] = 2 * a[i] - 1;
            }
            for (int i = mid + 1; i <= hi; i++) {
                a[i] = 2 * a[i];
            }
        }
    }
}
