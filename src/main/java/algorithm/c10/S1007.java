package algorithm.c10;

/**
 * @author : panjixiang
 * @since : 2022/11/16
 */
public class S1007 {
    class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            // 两次遍历，一次验证可行性
            // 一次统计
            int len = tops.length;
            int count = (1 << 7) - 1;
            for (int i = 0; i < len; i++) {
                int curr = (1 << tops[i] - 1) | (1 << bottoms[i] - 1);
                count &= curr;
                if (count == 0) {
                    return -1;
                }
            }
            int target = 1;
            for (int i = 0; i < 6; i++) {
                if ((count & (1 << i)) > 0) {
                    target = i + 1;
                    break;
                }
            }
            int up = 0;
            int down = 0;
            for (int i = 0; i < len; i++) {
                if (tops[i] != target) {
                    up++;
                }
                if (bottoms[i] != target) {
                    down++;
                }
            }
            return Math.min(up, down);
        }
    }
}
