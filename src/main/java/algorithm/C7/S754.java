package algorithm.C7;

import java.util.Arrays;

public class S754 {
    public int reachNumber(int target) {
        // 1 2 3 4 5 6 7 8 9
        // 选择+-号，使得和为target
        target = Math.abs(target);
        int sum = 0;
        int i = 1;
        while (true) {
            sum += i;
            if (sum == target || (sum - target) % 2 == 0) return i;
            i++;
        }
    }
}
