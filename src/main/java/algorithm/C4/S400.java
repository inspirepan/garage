package algorithm.C4;

public class S400 {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        //找规律，1-9  10-99 *2 100*999 *3 1000-9999 *4 ...
        int k = 1;
        while (n > digitCount(k)) {
            n -= digitCount(k);
            k++;
        }
        // 确定在几位数：k
        // 确定所在的数
        long number = (n - 1) / k + (int) Math.pow(10, k - 1);
        // k位数左起第t位
        int t = n % k == 0 ? k : n % k;
        t = k - t;
        while (t > 0) {
            t--;
            number /= 10;
        }
        return (int) number % 10;
    }

    private static long digitCount(int k) {
        return k * (long) (Math.pow(10, k) - Math.pow(10, k - 1));
    }

    public int findNthDigit2(int n) {
        int digit = 1;   // n所在数字的位数
        long start = 1;  // 数字范围开始的第一个数
        long count = 9;  // 占多少位
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}

