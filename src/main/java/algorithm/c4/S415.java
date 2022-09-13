package algorithm.c4;

public class S415 {
    public String addStrings(String num1, String num2) {
        // 双指针竖式计算
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int i = c1.length - 1;
        int j = c2.length - 1;
        int carry = 0;
        var sb = new StringBuilder();
        // 最后要reverse一下
        while (i >= 0 || j >= 0) {
            int digit = 0;
            if (i >= 0) {
                digit += (c1[i--] - '0');
            }
            if (j >= 0) {
                digit += (c2[j--] - '0');
            }
            digit += carry;
            sb.append(digit % 10);
            if (digit >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
