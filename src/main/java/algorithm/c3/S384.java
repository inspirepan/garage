package algorithm.c3;

import java.util.Random;

public class S384 {
    class Solution {

        int[] origin;

        public Solution(int[] nums) {
            this.origin = nums;
        }

        public int[] reset() {
            int[] rst = new int[origin.length];
            System.arraycopy(origin, 0, rst, 0, origin.length);
            return rst;
        }

        public int[] shuffle() {
            int len = origin.length;
            int[] shuffled = new int[len];
            shuffled[0] = origin[0];
            Random r = new Random();
            for (int i = 1; i < len; i++) {
                // 每个数被选取的概率是一样的
                int rand = r.nextInt(i + 1);
                shuffled[i] = shuffled[rand];
                shuffled[rand] = origin[i];
            }
            return shuffled;
        }
    }
}
