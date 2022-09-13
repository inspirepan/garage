package algorithm.c15;

import java.util.LinkedList;

public class S1536 {
    public int minSwaps(int[][] grid) {
        // 如果满足第0行要求的行有多行，那一定是选最上面的，这样子交换次数最少
        // 直接用LinkedList模拟移动
        LinkedList<Integer> list = new LinkedList<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int k = n - 1;
            while (k >= 0 && grid[i][k] == 0) {
                k--;
            }
            list.add(n - k - 1);
        }
        int count = 0;
        // i：行
        for (int i = 0; i < n - 1; i++) {
            int target = n - i - 1;
            int j = 0;
            while (j < n - i) {
                if (list.get(j) >= target) {
                    count += j;
                    list.remove(j);
                    break;
                }
                j++;
            }
            if (j == n - i) {
                return -1;
            }
        }
        return count;
    }
}
