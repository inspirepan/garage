package algorithm.c7;

public class S738 {
    public int monotoneIncreasingDigits(int n) {
        String num = String.valueOf(n);
        char[] arr = num.toCharArray();
        int len = arr.length;
        if (len < 2) {
            return n;
        }
        for (int i = len - 2; i >= 0; i--) {
            // 往前找
            // 如果前面的大于后面的、逆序，前面的-1，后面的全部变成9
            if (arr[i] - '0' > arr[i + 1] - '0') {
                arr[i] = (char) (arr[i] - '1' + '0');
                for (int j = i + 1; j < len; j++) {
                    arr[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(arr));
    }
}
