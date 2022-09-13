package algorithm;

public class S2038 {
    public boolean winnerOfGame(String colors) {
        // Alice要赢，就是Bob操作的时候，没有一个连续的三个B
        // 当没有三个连续的A的时候Alice就输了
        // 每次Alice删除的时候，可以选择删除一连串至少3个a的中间一个a删除，
        // 可是Alice选哪一个删除对Bob的选择都没有影响，只需要统计字符串中Alice和Bob可以删除的数量就可以了
        int countA = 0;
        int countB = 0;
        int p = 0;
        char[] c = colors.toCharArray();
        boolean isA = c[0] == 'A';
        while (p < c.length) {
            int q = p;
            while (p < c.length && c[p] == (isA ? 'A' : 'B')) {
                p++;
            }
            int t = p - q - 2;
            if (t > 0) {
                if (isA) {
                    countA += t;
                } else {
                    countB += t;
                }
            }
            isA = !isA;
        }
        return countA > countB;
    }
}
