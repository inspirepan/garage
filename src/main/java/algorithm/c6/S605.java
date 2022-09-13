package algorithm.c6;

public class S605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        // left 0
        int left = 0;
        int len = flowerbed.length;
        while (left < len && flowerbed[left] == 0) {
            left++;
        }
        // all 0
        if (left == len) {
            return (left + 1) / 2 >= n;
        }
        count += left / 2;
        // right 0
        int right = len - 1;
        while (flowerbed[right] == 0) {
            right--;
        }
        count += (len - 1 - right) / 2;
        // interval 0
        while (left < right) {
            while (left < right && flowerbed[left] == 1) {
                left++;
            }
            int t = left;
            while (left < right && flowerbed[left] == 0) {
                left++;
            }
            count += (left - t - 1) / 2;
        }
        return count >= n;
    }
}
