package algorithm;

public class S1064 {
    public int fixedPoint(int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left >>> 1);
            if (arr[mid] >= mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == arr.length) return -1;
        if (arr[left] == left) return left;
        return -1;
    }
}
