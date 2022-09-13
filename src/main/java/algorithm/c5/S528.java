package algorithm.c5;

import java.util.TreeMap;

public class S528 {
    int sum = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public S528(int[] w) {
        for (int i = 0; i < w.length; i++) {
            map.put(sum, i);
            sum += w[i];
        }
    }

    public int pickIndex() {
        double rand = Math.random();
        int r = (int) (rand * sum);
        return map.get(map.floorKey(r));
    }
}
