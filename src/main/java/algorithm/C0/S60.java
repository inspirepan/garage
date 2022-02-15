package algorithm.C0;

public class S60 {
    /**
     * 全排列第k个数
     * 1234
     * 1243
     * 1324
     * 1342
     * 1423
     * 1432
     *
     * 完了看不太懂自己之前做的，数学方法
     */
    public static String getPermutation(int n, int k) {
        // 让k索引从0开始
        k--;
        var sb = new StringBuilder();
        // 剩余的数字，0表示未使用，1表示使用
        int[] restNumber = new int[n];
        // 一共生成n位
        for (int i = n - 1; i >= 0; i--) {
            // 取出第几位
            int seq = k / fact(i);
            int m = 0;
            while (seq >= 0) {
                if (restNumber[m] != 1) {
                    seq--;
                }
                m++;
            }
            sb.append(m);
            restNumber[m - 1] = 1;
            k %= fact(i);
        }
        return sb.toString();
    }

    private static int fact(int n) {
        return switch (n) {
            case 0, 1 -> 1;
            case 2 -> 2;
            case 3 -> 6;
            case 4 -> 24;
            case 5 -> 120;
            case 6 -> 720;
            case 7 -> 5040;
            case 8 -> 40320;
            case 9 -> 362880;
            default -> 0;
        };
    }
}
