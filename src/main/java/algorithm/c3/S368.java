package algorithm.c3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 动态规划，每个位置保存的是包含了这个数的最长整除子集
        // 这样子写没有剪枝，遍历了全部的情况，实际上，最一个整除子集中，如果已经判断了可以加入到最后一个，那就不需要再去判断前面的了
        // 可以用一个结构来记录这个数组中前面的元素的坐标用来剪枝？
        // 不能贪心的
        Arrays.sort(nums);
        // 用一个List数组来保存结果
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return List.of(nums[0]);
        }
        // 还是用双重List代替数组，不过要注意初始化的问题，在每次循环中都先add一下
        List<LinkedList<Integer>> dp = new ArrayList<>();
        var t0 = new LinkedList<Integer>();
        t0.add(nums[0]);
        dp.add(t0);
        List<Integer> ans = t0;
        for (int i = 1; i < len; i++) {
            // 查看能不能加入整除集中
            // 先放一个自己的list
            var t = new LinkedList<Integer>();
            int k = 0;
            int current = nums[i];
            t.add(current);
            dp.add(t);
            while (k < i) {
                // 如果k整除最后一个，
                if (current % nums[k] == 0) {
                    var listK = dp.get(k);
                    if (listK.size() + 1 > dp.get(i).size()) {
                        // 添加当前元素，修改dp
                        var t2 = new LinkedList<>(listK);
                        t2.add(current);
                        dp.set(i, t2);
                        // 更新最长的结果
                        if (t2.size() > ans.size()) {
                            ans = t2;
                        }
                    }
                }
                k++;
            }
        }
        return ans;
    }
}
