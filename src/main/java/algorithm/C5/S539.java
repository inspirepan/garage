package algorithm.C5;

import java.util.Collections;
import java.util.List;

public class S539 {
    public int findMinDifference(List<String> timePoints) {
        // 这个剪枝可以快很多
        if (timePoints.size() >= 24 * 60) {
            return 0;
        }
        Collections.sort(timePoints);
        int min = diff("00:00", timePoints.get(0)) + diff(timePoints.get(timePoints.size() - 1), "24:00");
        for (int i = 0; i < timePoints.size() - 1; i++) {
            min = Math.min(min, diff(timePoints.get(i), timePoints.get(i + 1)));
        }
        return min;
    }

    private int diff(String a, String b) {
        int hour1 = Integer.parseInt(a.substring(0, 2));
        int hour2 = Integer.parseInt(b.substring(0, 2));
        int min1 = Integer.parseInt(a.substring(3, 5));
        int min2 = Integer.parseInt(b.substring(3, 5));
        return (hour2 - hour1) * 60 + min2 - min1;
    }
}
