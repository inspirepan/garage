package algorithm.C1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S170 {
    class TwoSum {
        // sorted
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        public TwoSum() {
            // 考虑重复的整数，是否出现超过两次
        }

        public void add(int number) {
            if (duplicate.contains(number)) return;
            if (set.contains(number)) {
                duplicate.add(number);
                return;
            }
            set.add(number);
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = left + (right - left >>> 1);
                if (list.get(mid) > number) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            list.add(left, number);
        }

        public boolean find(int value) {
            if ((value & 1) == 0) {
                if (duplicate.contains(value >> 1)) return true;
            }
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                int sum = list.get(left) + list.get(right);
                if (sum == value) return true;
                else if (sum > value) right--;
                else left++;
            }
            return false;
        }
    }
}
