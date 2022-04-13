package algorithm;

import java.util.HashMap;
import java.util.Map;

public class S1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // 每一行也就两个状态，翻转或者不翻转
        // 统计2m个状态中出现次数最多的就可以了
        // 但是有300多列，怎么统计呢

        int m = matrix.length;
        int n = matrix[0].length;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            var sb1 = new StringBuilder();
            var sb2 = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int k = matrix[i][j];
                sb1.append(k);
                sb2.append(k ^ 1);
            }
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            map.put(s1, map.getOrDefault(s1, 0) + 1);
            map.put(s2, map.getOrDefault(s2, 0) + 1);
        }
        int res = 1;
        for (int i : map.values()) {
            res = Math.max(res, i);
        }
        return res;
    }
}
