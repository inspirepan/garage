package algorithm.c1;

public class S168 {
    public String convertToTitle(int n) {
        var sb = new StringBuilder();
        // 反着来比较容易思考

        // ABC
        // AA = 27 = 26*1 + 1
        // AZ = 51 = 26*1 + 26
        // BBB = 26^2*2 + 26*2 + 2 = 1406
        // 为什么要--呢，是因为26*1这个是Z，每次的余数是1~26的范围
        while (n > 0) {
            int digit = --n % 26;
            sb.append((char) (digit + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int i = arr.length - 1;
        int res = 0;
        int exp = 1;
        while (i >= 0) {
            res += (arr[i] - 'A' + 1) * exp;
            exp *= 26;
            i--;
        }
        return res;
    }
}
