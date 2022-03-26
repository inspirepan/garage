package algorithm.F1;

public class S11 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 1 || numbers[len - 1] > numbers[0]) return numbers[0];
        int i = len - 1;
        while (i >= 1 && numbers[i] >= numbers[i - 1]) {
            i--;
        }
        return numbers[i];
    }
}
