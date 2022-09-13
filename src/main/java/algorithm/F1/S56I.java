package algorithm.F1;

public class S56I {
    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        // 全部数异或，得到两个不同数的异或结果
        int flag = x & (-x);
        // 这个操作可以得到x的最低位1，利用这个最低位1来分组，把两个不同的数区分开
        for (int n : nums) {
            if ((flag & n) == 0) {
                result[0] ^= n;
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }
}
