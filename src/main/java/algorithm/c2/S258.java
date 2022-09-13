package algorithm.c2;

public class S258 {
    public int addDigits(int num) {
        while (num > 9) {
            int t = 0;
            while (num > 0) {
                t += num % 10;
                num /= 10;
            }
            num = t;
        }
        return num;
    }
}
