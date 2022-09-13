package algorithm.c5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S506 {
    public String[] findRelativeRanks(int[] score) {
        int[] scoreCopy = new int[score.length];
        System.arraycopy(score, 0, scoreCopy, 0, scoreCopy.length);
        Arrays.sort(scoreCopy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(scoreCopy[i], score.length - i);
        }
        // 每一个元素对应的排名
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            String v;
            int rank = map.get(score[i]);
            if (rank == 1) {
                v = "Gold Medal";
            } else if (rank == 2) {
                v = "Silver Medal";
            } else if (rank == 3) {
                v = "Bronze Medal";
            } else {
                v = String.valueOf(rank);
            }
            result[i] = v;
        }
        return result;
    }
}
