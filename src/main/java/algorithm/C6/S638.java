package algorithm.C6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S638 {
    int min = Integer.MAX_VALUE;
    int n;
    Integer[] price;
    List<List<Integer>> special;
    Integer[] needs;
    Set<List<Integer>> visited = new HashSet<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // dfs探索全部礼包的组合，如果当前数量超过needs就不行，如果不足、用price零售价补足，求一个最小值
        // 表示每一个礼包的购买数量
        List<Integer> specialCount = new ArrayList<>();
        for (int i = 0; i < special.size(); i++) {
            specialCount.add(0);
        }
        this.n = price.size();
        int[] currCount = new int[n];
        // 把List换成Integer[]数组，从126ms变成了4ms，啊
        this.price = price.toArray(new Integer[price.size()]);
        this.special = special;
        this.needs = needs.toArray(new Integer[needs.size()]);
        dfs(specialCount, currCount);
        return min;
    }

    private void dfs(List<Integer> spc, int[] currCount) {
        // 如果当前组合购买的数量大于needs，不行]
        if (visited.contains(spc)) return;
        visited.add(spc);
        // 当前开销
        int currPrice = 0;
        for (int k = 0; k < spc.size(); k++) currPrice += spc.get(k) * special.get(k).get(n);
        int[] remain = new int[n];
        for (int i = 0; i < n; i++) {
            remain[i] = needs[i] - currCount[i];
            currPrice += (needs[i] - currCount[i]) * price[i];
        }

        min = Math.min(min, currPrice);
        for (int k = 0; k < spc.size(); k++) {
            List<Integer> sp = special.get(k);
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (remain[i] < sp.get(i)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                spc.set(k, spc.get(k) + 1);
                for (int i = 0; i < n; i++) currCount[i] += sp.get(i);
                dfs(spc, currCount);
                spc.set(k, spc.get(k) - 1);
                for (int i = 0; i < n; i++) currCount[i] -= sp.get(i);
            }
        }
    }
}
