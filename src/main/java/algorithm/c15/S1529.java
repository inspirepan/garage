package algorithm.c15;

public class S1529 {
    public int minFlips(String target) {
        // 逆向操作是一样的
        // 从最低位开始遍历
        // 翻转次数从0开始累积
        // 如果当前次数是偶数，那么遇到1需要翻转
        // 如果当前次数是奇数，那么遇到0需要翻转
        char[] c = target.toCharArray();
        int i = 0;
        int flips = 0;
        while (i < c.length) {
            if (c[i] == '1' && (flips & 1) == 0) {
                flips++;
            }
            if (c[i] == '0' && (flips & 1) == 1) {
                flips++;
            }
            i++;
        }
        return flips;
    }
}
