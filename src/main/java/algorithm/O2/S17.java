package algorithm.O2;

public class S17 {
    public int[] printNumbers(int n) {
        int max = 0;
        while (n > 0) {
            max += 9;
            max *= 10;
            n--;
        }
        max /= 10;
        int[] result = new int[max];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
