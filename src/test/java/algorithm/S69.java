package algorithm;

public class S69 {
    public int mySqrt(int x) {
        if (x==0) return 0;
        if (x <= 2) return 1;
        int left = 2;
        int right = x / 2;
        while (right >= left) {
            int mid = (right - left) / 2 + left;
            if (x/mid>= mid) left = mid + 1;
            else if (x/mid<mid) right = mid - 1;
        }
        return right;

    }
}
