package algorithm;

public class S135 {
    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length == 0) {
            return 0;
        }
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
