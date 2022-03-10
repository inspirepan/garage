package algorithm.C4;

import java.util.Arrays;

public class S481 {
    public int magicalString(int n) {
        // 最多连续出现两个1或者两个2，然后根据1、2生成
        // 1 2 2 1 1
        if (n == 1) return 1;
        if (n == 2) return 1;
        int[] magical = new int[n];
        magical[0] = 1;
        magical[1] = 2;
        magical[2] = 2;
        int count1 = 1;
        int p = 2;
        int q = 3;
        boolean is1 = true;
        while (q < n) {
            // System.out.println(Arrays.toString(magical)+" "+p+" "+magical[p]);
            if (magical[p] == 1) {
                if (is1) {
                    magical[q++] = 1;
                    count1++;
                } else magical[q++] = 2;
            } else if (magical[p] == 2) {
                if (is1) {
                    magical[q++] = 1;
                    count1++;
                    if (q < n) {
                        magical[q++] = 1;
                        count1++;
                    }
                } else {
                    magical[q++] = 2;
                    if (q < n) magical[q++] = 2;
                }
            }
            p++;
            is1 = !is1;
        }
        return count1;
    }
}
