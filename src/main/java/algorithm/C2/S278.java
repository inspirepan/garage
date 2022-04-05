package algorithm.C2;

public class S278 {

    int firstBadVersion = 2;

    boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left >>> 1);
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
