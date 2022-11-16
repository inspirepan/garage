package algorithm.c10;

public class S1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            // 将weight分成days个子数组，求和的最小值
            int max = weights[0];
            int sum = 0;
            for (int i : weights) {
                max = Math.max(max, i);
                sum += i;
            }
            int left = max;
            int right = sum;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (check(weights, days, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        boolean check(int[] weights, int days, int cap) {
            int count = 1;
            int sum = 0;
            for (int i : weights) {
                if (sum + i > cap) {
                    sum = i;
                    count++;
                } else {
                    sum += i;
                }
            }
            return count <= days;
        }
    }
}
