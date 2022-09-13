package algorithm.f1;

public class S64 {
    public int sumNums(int n) {
        // 因为10000<2^14，所以n最多14位二进制数，所以我倒是可以枚举相加模拟二进制乘法
        int p = n + 1;
        int result = 0;
        result += times(n, p, 0);
        result += times(n, p, 1);
        result += times(n, p, 2);
        result += times(n, p, 3);
        result += times(n, p, 4);
        result += times(n, p, 5);
        result += times(n, p, 6);
        result += times(n, p, 7);
        result += times(n, p, 8);
        result += times(n, p, 9);
        result += times(n, p, 10);
        result += times(n, p, 11);
        result += times(n, p, 12);
        result += times(n, p, 13);
        result >>>= 1;
        return result;
    }

    private int times(int a, int b, int i) {
        // 第i位
        a <<= i;
        int k = 1;
        k <<= i;
        b &= k;
        b = -b;
        return a & b;
    }
}
