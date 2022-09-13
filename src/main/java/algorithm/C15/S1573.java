package algorithm.C15;

public class S1573 {
    public int numWays(String s) {
        // 1的个数要一样，那么，统计1的倍数，如果不是3的倍数那么为0，然后看(count/3,count/3+1) (count/3*2,count/3*2+1)中间有几个0可以用来切割
        // 100010001000100010001

        // 无语了这道题，算法这么简单，结果折腾了半天，因为无语的超长数据，得用long，两个数的乘法还要用for循环加起来算，恶心
        int len = s.length(), mod = (int) Math.pow(10, 9) + 7;
        if (len <= 2) {
            return 0;
        }
        int[] index = new int[len];
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                index[k++] = i;
            }
        }
        if (k == 0) {
            long l = 0;
            if ((len & 1) == 1) {
                for (int i = 0; i < (len - 2); i++) {
                    l = (l + (len - 1) / 2) % mod;
                }
            } else {
                for (int i = 0; i < (len - 1); i++) {
                    l = (l + (len - 2) / 2) % mod;
                }
            }
            return (int) l;
        }
        if (k % 3 != 0) {
            return 0;
        }
        int t = k / 3;
        long m = 0;
        int p = index[2 * t] - index[2 * t - 1];
        for (int i = 0; i < index[t] - index[t - 1]; i++) {
            m = (m + p) % mod;
        }
        return (int) m;
    }
}
