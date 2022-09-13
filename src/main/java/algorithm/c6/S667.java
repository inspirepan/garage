package algorithm.c6;

public class S667 {
    public int[] constructArray(int n, int k) {
        // n-1个距离，只有k种，填入1~n
        // 没有思路啊
        // 1 9 3 4 5 6 7 8 2 10
        // 如果先按顺序排好，那么只有一种距离1，然后互换中间两个i,j，那么会增加距离 j-i+1和j-i-1两种距离
        // 1 9 3 7 5 6 4 8 2 10
        // 1 9 8 4 5 6 7 3 2 10
        // 假如k=6，除开1之外需要5种
        // 1 6 2 5 3 4 7 8 9 10
        // 所以来回加减就可以了
        // 1 7 2 6 3 5 4 8
        int[] ans = new int[n];
        ans[0] = 1;
        int diff = k;
        boolean positive = true;
        int i = 1;
        while (diff >= 1) {
            int temp = positive ? diff : -diff;
            ans[i] = ans[i - 1] + temp;
            i++;
            diff--;
            positive = !positive;
        }
        ++k;
        for (; i < ans.length; i++) {
            ans[i] = ++k;
        }
        return ans;
    }
}
