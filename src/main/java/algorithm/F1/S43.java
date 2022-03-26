package algorithm.F1;

public class S43 {
    public int countDigitOne(int n) {
        // 完全不会，题解也不想看
        int num = n, i = 1, s = 0;

        while (num > 0)              //分别计算个、十、百......千位上1出现的次数，再求和。
        {
            // 40 -> 01 11 21 31
            if (num % 10 == 0)
                s = s + (num / 10) * i;
            // 41 -> 01 11 21 31 41
            if (num % 10 == 1)
                s = s + (num / 10) * i + (n % i) + 1;

            if (num % 10 > 1)
                s = s + (num / 10) * i;

            num = num / 10;
            i = i * 10;
        }
        return s;
    }
}
