package algorithm.c9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : panjixiang
 * @since : 2022/11/11
 */
public class S989 {
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> res = new ArrayList<>();
            int i = num.length - 1;
            int carry = 0;
            while (k > 0 || i >= 0) {
                int digit = 0;
                if (k > 0 && i >= 0) {
                    digit = carry + k % 10 + num[i];
                } else if (k > 0) {
                    digit = carry + k % 10;
                } else {
                    digit = carry + num[i];
                }
                carry = digit >= 10 ? 1 : 0;
                digit %= 10;
                res.add(0, digit);
                i--;
                k /= 10;
            }
            if (carry == 1) {
                res.add(0, 1);
            }
            return res;
        }
    }
}
