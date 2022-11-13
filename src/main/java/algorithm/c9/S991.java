package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/11/11
 */
public class S991 {
    class Solution {
        public int brokenCalc(int startValue, int target) {
            // 这还是个思路问题
            // BFS 会超时
            int step = 0;
            if (target <= startValue) {
                return startValue - target;
            }
            while (target > startValue) {
                if ((target & 1) == 1) {
                    target++;
                } else {
                    target >>>= 1;
                }
                ++step;
            }
            step += startValue - target;

            return step;
        }
    }
}
