package algorithm.c14;

import java.util.HashSet;
import java.util.Set;

public class S1461 {

    public boolean hasAllCodes(String s, int k) {
        int left = 0, right = k;
        Set<String> set = new HashSet<>();
        while (right <= s.length()) {
            set.add(s.substring(left, right));
            left++;
            right++;
        }
        // 必然是包括2^k种不同的排列的
        return set.size() == Math.pow(2, k);
    }
}
