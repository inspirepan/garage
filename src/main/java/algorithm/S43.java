package algorithm;

/**
 * 思路，先不管进位，只管两个数中的各个位置相乘，然后再处理两轮进位
 */
public class S43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // 因为个位数相乘结果最大只有两位，先不管进位
        var sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = 0; i < len1 + len2; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < len1 && i - j < len2) {
                    char c1 = num1.charAt(len1 - 1 - j);
                    char c2 = num2.charAt(len2 - 1 - (i - j));
                    int temp = (c1 - '0') * (c2 - '0');
                    result[i] += temp;
                }
            }
        }
        /*
        int[] answer = new int[len1 + len2];
        // 处理进位
        for (int i = 0; i < len1 + len2; i++) {
            if (result[i] > 10) {
                int raw = result[i];
                int carryTimes = 0;
                while (raw > 0) {
                    answer[i + carryTimes] += raw % 10;
                    raw /= 10;
                    carryTimes++;
                }
            } else {
                answer[i] += result[i];
            }
        }
        // 处理answer中的进位，为什么只用处理一位呢，是因为只有这么大
        for (int i = 0; i < len1 + len2; i++) {
            if (answer[i] >= 10) {
                answer[i + 1] += (answer[i] / 10);
                answer[i] %= 10;
            }
        }
        boolean started = false;
        for (int i = len1 + len2 - 1; i >= 0; i--) {
            if (answer[i] > 0) {
                started = true;
            }
            if (started) {
                sb.append(answer[i]);
            }
        }
        */

        for (int i = 0; i < len1 + len2 - 1; i++) {
            result[i + 1] += result[i] / 10;
            result[i] %= 10;
        }
        if (result[len1 + len2 - 1] != 0) {
            sb.append(result[len1 + len2 - 1]);
        }
        for (int i = len1 + len2 - 2; i >= 0; i--) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    /**
     * 参考答案
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] temp = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                temp[i + j + 1] += a * b;
            }
        }
        for (int i = len1 + len2 - 1; i > 0; i--) {
            temp[i - 1] += temp[i] / 10;
            temp[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        // 这么做是因为只有可能第0位是0？11*11=121 99*99=9801
        if (temp[0] != 0) sb.append(temp[0]);
        for (int i = 1; i <= len1 + len2 - 1; i++) {
            sb.append(temp[i]);
        }
        return sb.toString();
    }
}
