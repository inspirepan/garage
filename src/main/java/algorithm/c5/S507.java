package algorithm.c5;

public class S507 {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        if (1 == num) {
            return false;
        }
        int i = 2;
        while (i * i <= num) {
            if (num % i == 0) {
                sum += i;
                if (num > i * i) {
                    sum += num / i;
                }
            }
            i++;
        }
        return num == sum;
    }
}
