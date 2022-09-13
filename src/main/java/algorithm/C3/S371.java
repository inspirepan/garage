package algorithm.C3;

public class S371 {
    public int getSum(int a, int b) {

        // 感觉是二进制题，要不模拟一遍加法器？
        int sum = a ^ b;
        // 这样可以解决每个位置单独的问题，需要再处理一下进位的问题
        int carry = a & b;
        carry <<= 1;
        if (carry == 0) {
            return sum;
        }
        return getSum(sum, carry);
    }
}
