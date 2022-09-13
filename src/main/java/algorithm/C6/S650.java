package algorithm.C6;

import java.util.HashMap;
import java.util.Map;

public class S650 {
    Map<Integer, Integer> map = new HashMap<>();

    public int minSteps(int n) {
        map.put(1, 0);
        map.put(2, 2);
        int k = helper(n);
        System.out.println(map);
        return k;
    }

    private int helper(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        // 探索每一个因数
        // 至少有一个1
        int temp = n;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.println(i);
                temp = Math.min(temp, helper(i) + n / i);
            }
        }
        map.put(n, temp);
        return temp;
    }
}
