package algorithm.C5;

import java.util.HashMap;
import java.util.Map;

public class S509 {
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) return map.get(n);
        int result = fib(n - 1) + fib(n - 2);
        map.put(n, result);
        return result;
    }
}
