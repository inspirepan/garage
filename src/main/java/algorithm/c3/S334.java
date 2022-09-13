package algorithm.c3;

public class S334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= max) {
                max = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        // 就是300题最长递增子序列啊
        // 用300题的思路算一哈
        int len = nums.length;
        int[] tails = new int[len];
        int end = -1;
        for (int n : nums) {
            if (end == -1) {
                tails[++end] = n;
            } else {
                if (n > tails[end]) {
                    tails[++end] = n;
                    if (end == 3) {
                        return true;
                    }
                } else {
                    int left = 0;
                    int right = end + 1;
                    while (left < right) {
                        int mid = left + (right - left >>> 1);
                        if (tails[mid] > n) {
                            right = mid;
                            // 遇到一样的数就不要管了
                            // 因为这道题的递增序列是严格的，所以tails中的序列也应该是去重的，因此二分搜索到了就直接break了
                        } else if (tails[mid] == n) {
                            left = mid;
                            break;
                        } else {
                            left = mid + 1;
                        }
                    }
                    tails[left] = n;
                }
            }
        }
        return false;
    }
}
