package algorithm.C0;

public class S66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        while (--n >= 0) {
            digits[n] = (digits[n] + 1) % 10;
            if (digits[n] != 0) {
                return digits;
            }
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
