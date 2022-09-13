package algorithm;

public class S1994 {
        /* 这题的难点是怎么判断子集元素乘积是互不相同质数的积啊
         首先都是乘积，如果子集中的合数本身不能分解成两个不同的质数，那就不符合要求，比如4，9
         把合数分解成质数，然后看所有质数元素是否重复即可
         注意单个1不是质数，另外这题用的不是连续子数组，是子集

         注意到元素最大只到30，所以完全可以列举判断下，符合要求的合数只有这些
         6 10 14 15 21 26 30*/

        /*看了别人的题解，如何处理质数的，还是很朴素的，就是把30以内的质数列举出来，对于每种元素，从2开始一路除下去，
        如果能整除两次以上，说明质数因数重复，不符合要求，
        然后用一个f[1<<10]，拨码开关一样的编码方案来保存不同质数组合情况，蛮巧妙的*/

    int MOD = (int) 1e9 + 7;
    // 质数
    int[] p = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    int[] cnts = new int[35];

    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length;
        // 统计每个数出现的频率
        for (int i : nums) {
            cnts[i]++;
        }
        int mask = 1 << 10;
        // 结果数组，之所以要这么大，是可以通过不同下标表示不同的质数组合情况，例如235那下标就是 00000101100
        long[] f = new long[mask];
        f[0] = 1;
        // 对于小于30的每个数
        for (int i = 2; i <= 30; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            // 对i进行试除，cur是放入结果数组的下标
            int cur = 0, x = i;
            boolean ok = true;
            // 对于每个质数
            for (int j = 0; j < 10; j++) {
                int t = p[j], c = 0;
                // 如果当前数可以整除当前质数
                while (x % t == 0) {
                    // 生成一个f数组下标
                    cur |= (1 << j);
                    // 除掉
                    x /= t;
                    c++;
                }
                // 如果i能够被同一质数试除多次，说明i不能加到子集，跳过i
                if (c > 1) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                continue;
            }
            // 枚举前一状态prev 2*3 0000110
            // 当前状态cur 2*3*5 0010110
            for (int prev = mask - 1; prev >= 0; prev--) {
                // 只有当前选择数与前一状态不冲突，则能够进行转移，将方案数进行累加
                // 与操作必须是全部为0才不冲突
                if ((prev & cur) != 0) {
                    continue;
                }
                // 状态转移，加上新的数之后，不同下标算不同的子集，cnts[i]种
                f[prev | cur] = (f[prev | cur] + f[prev] * cnts[i]) % MOD;
            }
        }
        long ans = 0;
        // 统计所有非空集的方案数
        for (int i = 1; i < mask; i++) {
            ans = (ans + f[i]) % MOD;
        }
        // 在此基础上，考虑每个不同下标的1选择与否对答案的影响
        for (int i = 0; i < cnts[1]; i++) {
            ans = ans * 2 % MOD;
        }
        return (int) ans;
    }
}

