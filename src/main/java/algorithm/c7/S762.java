package algorithm.c7;

import java.util.HashMap;
import java.util.Map;

public class S762 {

    Map<Integer, Boolean> map = new HashMap<>();

    {
        map.put(1, false);
        map.put(2, true);
    }

    boolean isPrime(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        boolean flag = true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        map.put(n, flag);
        return flag;
    }

    public int countPrimeSetBits(int left, int right) {
        // [left, right]

        int count = 0;
        while (left <= right) {
            if (isPrime(Integer.bitCount(left++))) {
                count++;
            }
        }
        return count;
    }
}
