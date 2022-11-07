package algorithm.c7;

public class S754 {
    public int reachNumber(int target) {
        // 1 2 3 4 5 6 7 8 9
        // 选择+-号，使得和为target
        // 二分搜索的思路是: 最大值是 2*target，最小值是(1+n)*n/2>target
        // 正负是一样的结果
        target = Math.abs(target);
        int sum = 0;
        int i = 1;
        while (true) {
            sum += i;
            if (sum >= target && (sum - target) % 2 == 0) return i;
            i++;
        }
    }
}
