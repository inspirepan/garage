package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/11/15
 */
public class S997 {
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] count = new int[n + 1];
            for (int[] t : trust) {
                count[t[0]]--;
                count[t[1]]++;
            }
            for (int i = 1; i < count.length; i++) {
                if (count[i] == n - 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
