package algorithm.c14;

public class S1497 {
    public boolean canArrange(int[] arr, int k) {
        // 检查每个数除以k的余数
        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            // 考虑负数的余数
            if (rem < 0) {
                rem += k;
            }
            count[rem]++;
        }
        if ((count[0] & 1) != 0) {
            return false;
        }
        if ((k & 1) == 0 && (count[k >> 1] & 1) != 0) {
            return false;
        }
        int s = (k & 1) == 0 ? (k >> 1) - 1 : (k >> 1);
        for (int i = 1; i <= s; i++) {
            if (count[i] != count[k - i]) {
                return false;
            }
            if (((count[i] + count[k - i]) & 1) != 0) {
                return false;
            }
        }
        return true;
    }
}
