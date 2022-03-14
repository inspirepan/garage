package algorithm.C5;

import java.util.Collections;
import java.util.List;

public class S539 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int len = timePoints.size();
        if (len <= 1) return 0;
        if (len>=1440) return 0;
        int minDiff =
                Integer.parseInt(timePoints.get(0).substring(0, 2)) * 60
                        + Integer.parseInt(timePoints.get(0).substring(3, 5))
                        + (24 - Integer.parseInt(timePoints.get(len - 1).substring(0, 2))) * 60
                        - Integer.parseInt(timePoints.get(len - 1).substring(3, 5));
        for (int i = 1; i < len; i++) {
            if (timePoints.get(i).equals(timePoints.get(i - 1))) return 0;
            minDiff = Math.min(minDiff, getDiff(timePoints.get(i - 1), timePoints.get(i)));
        }
        return minDiff;
    }

    private int getDiff(String a, String b) {
        // assert a<b
        int minutes = 60 * (Integer.parseInt(b.substring(0, 2)) - Integer.parseInt(a.substring(0, 2)));
        minutes += Integer.parseInt(b.substring(3, 5)) - Integer.parseInt(a.substring(3, 5));
        return minutes;
    }
}
