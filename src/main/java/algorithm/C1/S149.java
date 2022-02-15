package algorithm.C1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S149 {
    /* 复制的题解 */
    /*
     * 没有算法，纯粹遍历 注意不能直接使用斜率比较
     */
    public int maxPoints(int[][] points) {
        // 当为0个点，1个点，2个点。他们必然共线
        if (points.length < 3) {
            return points.length;
        }
        // 创建哈希表，保存点与点之间的斜率
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        int n = points.length;
        int maxNum = 1;// K非0或者非无穷大的共线点个数
        int maxNumHrizt = 1;// 横向共线，即纵坐标相同点的个数k = 0
        int maxNumVerti = 1;// 纵向共线，即横坐标相同点的个数k = 无穷
        int maxNumSame = 1;// 相同点的个数
        int maxP = 0;// 最大共线点数
        for (int i = 0; i < n; i++) {// 从每个点开始，看看它后面的点是否共线
            maxNum = 1;
            maxNumHrizt = 1;
            maxNumVerti = 1;
            maxNumSame = 1;
            for (int j = i + 1; j < n; j++) {
                int num = points[j][1] - points[i][1];// 纵坐标之差，k的分子
                int den = points[j][0] - points[i][0];// 横坐标之差，k的分母
                // 横纵坐标差都为0，说明这两个点相同
                if (num == 0 && den == 0) {
                    maxNumSame++;
                }
                // 纵坐标之差为0，横坐标之差不为0，说明在水平上呈一条线
                else if (num == 0 && den != 0) {
                    maxNumHrizt++;
                }
                // 纵坐标之差为0，横坐标之差不为0，说明在水平上呈一条线
                else if (den == 0 && num != 0) {
                    maxNumVerti++;
                }
                // 横纵坐标之差都不为0
                else {
                    int positive = 1;// 设立一个标志，确定K值的正负
                    // 横纵坐标的差的乘积小于0，说明k为负
                    if (num * den < 0) {
                        positive = 0;
                    }
                    // 由于计算最大公因数时，要求数都为正数
                    num = Math.abs(num);
                    den = Math.abs(den);
                    int gcdnum = gcd(num, den);
                    // 化为最简分数
                    num /= gcdnum;
                    den /= gcdnum;
                    // 当k为负数时，为了将分子为负分母为正或者分子为正分母为负的情况统一起来，令分子始终为正，分母为负
                    if (positive == 0) {
                        den *= -1;
                    }
                    // k值用List表示，第一位为分子，第二位为分母
                    List<Integer> k = new ArrayList<Integer>();
                    k.add(num);
                    k.add(den);
                    // k值存在，就在原来的基础上+1；k值不存在，就在默认的1点共线上+1
                    map.put(k, map.getOrDefault(k, 1) + 1);
                    // 当k值对应的value（共线点个数）大于maxNum，更新maxNum
                    maxNum = Math.max(maxNum, map.get(k));
                }
            }
            // 在一个点与它后面所有点都计算完K值和共线点之后，求最多的共线点个数
            // 相同点和共线点要一起计算总个数
            // 在计算共线时，在相同的几个点中，多记录了一次所以要-1
            maxP = Math.max(maxP, maxNum + maxNumSame - 1);
            maxP = Math.max(maxP, maxNumHrizt + maxNumSame - 1);
            maxP = Math.max(maxP, maxNumVerti + maxNumSame - 1);
            map.clear();
        }
        return maxP;
    }

    private int gcd(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}