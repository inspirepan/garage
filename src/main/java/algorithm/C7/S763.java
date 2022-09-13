package algorithm.C7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S763 {
    public List<Integer> partitionLabels(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        // 统计每一个字母左右边界
        // 再去划分字符串的每一个长度

        char[] arr = s.toCharArray();

        // -1 represent no exists
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (left[c - 'a'] == -1) {
                left[c - 'a'] = i;
                right[c - 'a'] = i;
            } else {
                right[c - 'a'] = i;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (left[i] != -1) {
                map.put(left[i], right[i]);
            }
        }
        int l = 0;
        int r = map.get(l);
        while (r < arr.length) {
            int start = l;
            r = map.get(l);
            // 从当前l开始更新
            while (l <= r) {
                if (map.containsKey(l)) {
                    // 更新右界
                    r = Math.max(r, map.get(l));
                    if (r == arr.length - 1) {
                        break;
                    }
                }
                l++;
            }
            // l = r+1
            res.add(r - start + 1);
            if (r == arr.length - 1) {
                break;
            }
        }
        return res;
    }
}
