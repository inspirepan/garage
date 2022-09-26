package algorithm.c9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : panjixiang
 * @since : 2022/9/24
 */
public class S967 {
    List<Integer> result = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            helper(i, 1, n, k);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    void helper(int curr, int len, int n, int k) {
        if (len == n) {
            result.add(curr);
            return;
        }
        int last = curr % 10;
        for (int i = 0; i <= 9; i++) {
            if (Math.abs(last - i) == k) {
                helper(curr * 10 + i, len + 1, n, k);
            }
        }
    }
}
