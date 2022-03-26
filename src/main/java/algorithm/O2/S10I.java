package algorithm.O2;

import java.util.HashMap;
import java.util.Map;

public class S10I {
    Map<Integer, Integer> map = new HashMap();
    static final int MOD = 1000000007;

    {
        map.put(0, 0);
        map.put(1, 1);
    }

    public int fib(int n) {
        if (map.containsKey(n)) return map.get(n);
        int t = fib(n - 1) + fib(n - 2);
        t %= MOD;
        map.put(n, t);
        return t;
    }
}
