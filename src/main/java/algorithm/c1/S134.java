package algorithm.c1;

public class S134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len == 0) {
            return 0;
        }
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                minSum = sum;
                start = i;
            }
        }
        return sum >= 0 ? (start + 1) % len : -1;
    }
}