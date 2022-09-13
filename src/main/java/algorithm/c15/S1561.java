package algorithm.c15;

public class S1561 {
    public int maxCoins(int[] piles) {
        // 题目的意思就是说一定会有3的倍数长度
        // 反正给Bob分最少的len/3堆即可
        // 给Alice就是最多、第三多...这样子，sort一下很简单了
        // 可是sort太浪费时间了，怎么优化呢

        // 看了别人的方法，就是说用桶排序啊
        sort(piles);
        int len = piles.length;
        int ans = 0;
        for (int i = len / 3; i < len; i += 2) {
            ans += piles[i];
        }
        return ans;
    }

    // 计数排序，让复杂度从O(nlogn)降到O(max)
    public void sort(int[] piles) {
        int[] arr = new int[10001];
        for (int pile : piles) {
            arr[pile]++;
        }
        int idx = 0;
        for (int i = 0; i < 10001; i++) {
            while (arr[i] > 0) {
                piles[idx++] = i;
                arr[i]--;
            }
        }
    }
}
