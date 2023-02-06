package algorithm.c14;

import java.util.ArrayList;
import java.util.List;

public class S1456 {
    public int maxVowels(String s, int k) {
        // 滑动窗口
        List<Integer> list = new ArrayList<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 1;

        while (right < list.size()) {
            if (list.get(right) - list.get(left) < k) {
                max = Math.max(max, right - left + 1);
                // 扩大窗口
                right++;
            } else {
                // 右移窗口
                right++;
                left++;
            }
        }
        return max;
    }
}
