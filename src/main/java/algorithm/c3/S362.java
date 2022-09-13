package algorithm.c3;

import java.util.ArrayList;
import java.util.List;

public class S362 {
    class HitCounter {

        List<Integer> list = new ArrayList<>();

        public HitCounter() {

        }

        public void hit(int timestamp) {
            list.add(timestamp);
        }

        public int getHits(int timestamp) {
            int target = timestamp - 299;
            int left = 0;
            int right = list.size();

            while (left < right) {
                int mid = left + (right - left >>> 1);
                int midVal = list.get(mid);
                if (midVal >= target) {
                    right = mid;
                } else if (midVal < target) {
                    left = mid + 1;
                }
            }
            return list.size() - left;
        }
    }
}
