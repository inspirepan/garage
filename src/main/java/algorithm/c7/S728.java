package algorithm.c7;

import java.util.ArrayList;
import java.util.List;

public class S728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        while (left <= right) {
            if (isSDN(left)) {
                res.add(left);
            }
            left++;
        }
        return res;
    }

    private boolean isSDN(int n) {
        int i = n;
        while (i > 0) {
            int t = i % 10;
            if (t == 0) {
                return false;
            }
            if (t != 1) {
                if (n % t != 0) {
                    return false;
                }
            }
            i /= 10;
        }
        return true;
    }
}
