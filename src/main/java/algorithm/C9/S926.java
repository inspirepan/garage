package algorithm.C9;

public class S926 {
    public int minFlipsMonoIncr(String s) {
        // 统计每一个坐标前面有多少个1，后面有多少个0
        char[] c = s.toCharArray();
        int len = c.length;
        int[] left1 = new int[len + 1];
        int[] right0 = new int[len + 1];
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (c[i] == '1') count++;
            left1[i + 1] = count;
        }
        count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (c[i] == '0') count++;
            right0[i] = count;
        }
        int min = len;
        for (int i = 0; i <= len; i++) {
            min = Math.min(min, left1[i] + right0[i]);
        }
        return min;
    }
}
