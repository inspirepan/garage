package algorithm.C14;

import java.util.Arrays;

public class S1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // 原来是无序的啊
        // 原来直接排序就好了
        long maxHor = getMax(h, horizontalCuts);
        long maxVer = getMax(w, verticalCuts);
        // 取余数
        long a = (long) Math.pow(10, 9) + 7;
        return (int) ((maxVer * maxHor) % a);
    }

    private long getMax(int w, int[] cuts) {
        long max;
        if (cuts.length == 0) {
            max = w;
        } else {
            Arrays.sort(cuts);
            max = Math.max(cuts[0], w - cuts[cuts.length - 1]);
            for (int i = 1; i < cuts.length; i++) {
                max = Math.max(max, cuts[i] - cuts[i - 1]);
            }
        }
        System.out.println(max);
        return max;
    }
}
