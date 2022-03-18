package algorithm.C5;

import java.util.HashSet;
import java.util.Set;

public class S575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> type = new HashSet<>();
        for (int i : candyType) {
            type.add(i);
            if (type.size() >= candyType.length / 2) return candyType.length / 2;
        }
        return type.size();
    }
}
