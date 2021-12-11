package algorithm.S0to100;

public class Jd {
    /**
     * 16.16
     *
     * @param array numbers
     * @return subSort
     */
    public int[] subSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right && array[left] <= array[left + 1]) {
            left++;
        }
        while (right > 0 && array[right] >= array[right - 1]) {
            right--;
        }
        if (left >= right) {
            return new int[]{-1, -1};
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(array[i], min);
            max = Math.max(array[i], max);
        }
        while (left - 1 >= 0 && array[left - 1] > min) {
            left--;
        }
        while (right + 1 < array.length && array[right + 1] < max) {
            right++;
        }
        return new int[]{left, right};
    }
}
