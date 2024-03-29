package algorithm.c6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S672 {

    public int flipLights(int n, int presses) {
        // 不管怎么样，灯泡只有六类
        // 根据除以6的余数对应受到影响的操作
        // 0： 12
        // 1： 134
        // 2： 12
        // 3： 13
        // 4： 124
        // 5： 13
        Set<String> set = new HashSet<>();
        n = Math.min(n, 6);
        if (presses == 0) {
            return 1;
        }
        int[] operateTimes = new int[4];
        if (presses >= 1) {
            for (int i = 0; i < 4; i++) {
                operateTimes[i] = 1;
                set.add(currentResult(operateTimes, n));
                operateTimes[i] = 0;
            }
        }
        if (presses >= 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    operateTimes[i] = operateTimes[j] = 1;
                    set.add(currentResult(operateTimes, n));
                    operateTimes[i] = operateTimes[j] = 0;
                }
            }
        }
        Arrays.fill(operateTimes, 1);
        if (presses >= 3) {
            for (int i = 0; i < 4; i++) {
                operateTimes[i] = 0;
                set.add(currentResult(operateTimes, n));
                operateTimes[i] = 1;
            }
        }
        if (presses >= 4) {
            set.add(currentResult(operateTimes, n));
        }
        return set.size();
    }

    private String currentResult(int[] operateTimes, int n) {
        // n个灯泡，最多6种
        var sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int b = switch (i) {
                case 6, 2 -> (operateTimes[0] + operateTimes[1]) & 1;
                case 1 -> (operateTimes[0] + operateTimes[2] + operateTimes[3]) & 1;
                case 3, 5 -> (operateTimes[0] + operateTimes[2]) & 1;
                case 4 -> (operateTimes[0] + operateTimes[1] + operateTimes[3]) & 1;
                default -> 0;
            };
            sb.append(b);
        }
        return sb.toString();
    }
}
