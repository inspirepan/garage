package algorithm.c15;

public class S1524 {
    public int numOfSubarrays(int[] arr) {
        // 超时了哎呦
        int mod = 1000000007;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isOdd = (arr[i] & 1) == 1;
            if (isOdd) {
                count = ++count % mod;
            }
            for (int j = i + 1; j < arr.length; j++) {
                isOdd ^= (arr[j] & 1) == 1;
                if (isOdd) {
                    count = ++count % mod;
                }
            }
        }
        return count;
    }

    public int numOfSubarrays2(int[] arr) {
        int mod = 1000000007;
        // dp[i]表示右边界为dp[i]的子数组中奇数和的数量
        int[] odd = new int[arr.length];
        int[] even = new int[arr.length];
        odd[0] = (arr[0] & 1) == 1 ? 1 : 0;
        even[0] = (arr[0] & 1) == 0 ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                // 奇
                // 单个数
                odd[i]++;
                odd[i] += even[i - 1];
                even[i] += odd[i - 1];
            } else {
                // 偶
                even[i]++;
                odd[i] += odd[i - 1];
                even[i] += even[i - 1];
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = (count + odd[i]) % mod;
        }
        return count;
    }
}
