package algorithm.C3;

public class S367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // mid*mid会越界啊
            int t = num / mid;
            if (t == mid) {
                if (num % t == 0) {
                    return true;
                }
                left = mid + 1;
            } else if (t < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
