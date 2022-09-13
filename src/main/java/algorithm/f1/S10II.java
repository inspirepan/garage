package algorithm.f1;

import java.util.HashMap;
import java.util.Map;

public class S10II {
    static final int MOD = 1000000007;
    Map<Integer, Integer> map = new HashMap();

    {
        map.put(0, 0);
        map.put(1, 1);
    }

    public int numWays(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int t = numWays(n - 1) + numWays(n - 2);
        t %= MOD;
        map.put(n, t);
        return t;
    }
}
