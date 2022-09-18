package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/9/19
 */
public class S957 {
    class Solution {
        // 模拟会超时，有循环（没证明），需要找出循环然后运算对应余数次
        public int[] prisonAfterNDays(int[] cells, int n) {
            int bits = 0;
            for (int cell : cells) {
                bits <<= 1;
                bits += cell;
            }
            for (int i = 0; i < n; i++) {
                bits &= 0b01111110;
                System.out.println(Integer.toBinaryString(bits));
                int left = (bits >>> 1) & 0b01111111;
                int right = (bits << 1) & 0b11111110;
                bits = ~left ^ right;
            }
            int[] res = new int[8];
            for (int i = 7; i >= 0; i--) {
                res[i] = bits & 1;
                bits >>>= 1;
            }
            return res;
        }
    }
}
