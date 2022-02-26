package algorithm.C15;

public class S1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        // 先看了评论，说是时间可能超时，那就不模拟了
        if (arr.length == 1) return arr[0];
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // 每个数出现的次数
            sum = sum + arr[i] * ((i / 2 + 1) * ((n - i - 1) / 2 + 1) + ((i + 1) / 2) * ((n - i) / 2));
        }
        return sum;
    }
}
