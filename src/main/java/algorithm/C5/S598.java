package algorithm.C5;

public class S598 {
    public int maxCount(int m, int n, int[][] ops) {
        // ops的xy最小值
        int minX = m;
        int minY = n;
        for (int[] op : ops) {
            if (op[0] == 0 || op[1] == 0) continue;
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        return minX * minY;
    }
}
