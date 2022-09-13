package algorithm.c6;

import java.util.Arrays;

public class S621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int max = count[25];
        int res = (max - 1) * (n + 1) + 1;
        int i = 24;
        // 只需要考虑执行最多次数的即可？
        // 其他的去填这些max次数的空位就可以了，不知道为什么
        while (i >= 0 && count[i] == max) {
            res++;
            i--;
        }
        return Math.max(tasks.length, res);
    }
}
