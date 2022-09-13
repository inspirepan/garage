package algorithm.c15;

public class S1513 {
    public int numSub(String s) {
        String[] ss = s.split("0");
        // 懒得自己统计了，直接用split
        // 难点在数据类型
        long count = 0;
        long mod = 1000000007;
        for (String value : ss) {
            count = (count + singleSub(value.length())) % mod;
        }
        return (int) count;
    }

    public long singleSub(long i) {
        return (i + 1) * i / 2;
    }
}
