package algorithm.C6;

public class S633 {

    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int t = left * left - c;
            t += right * right;
            if (t < 0) {
                left++;
            } else if (t > 0) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
