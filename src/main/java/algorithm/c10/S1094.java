package algorithm.c10;

import java.util.TreeMap;

public class S1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        // 汽车只能向右形式，from上车to下车
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < trips.length; i++) {
            int[] curr = trips[i];
            map.put(curr[1], map.getOrDefault(curr[1], 0) + curr[0]);
            map.put(curr[2], map.getOrDefault(curr[2], 0) - curr[0]);
        }
        int sum = 0;
        for (int n : map.values()) {
            sum += n;
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
