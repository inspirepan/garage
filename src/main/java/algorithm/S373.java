package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        if(n == 0 || m == 0) return res;
        // 利用一个数组来保存nums1中每个元素对应的最小组合的nums2下标，初始值为0，因为刚开始每个元素对应的最小组合肯定是对面的第一个元素
        int[] f = new int[n];
        // 外层最多遍历k次，获取前k个最小值
        while(res.size() < k) {
            int cur = 0;
            // 遍历每个nums1元素对应nums2最小可用组合，并获取最小组合
            for(int i = 1; i < n; i++) {
                // 当前i位置可用组合已经用完了
                if(f[i] == m) continue;
                // 比较获取最小的组合
                if(f[cur] == m || nums1[cur] + nums2[f[cur]] > nums1[i] + nums2[f[i]]) {
                    cur = i;
                }
            }
            // 所有的组合都用完了，就跳出循环
            if(f[cur] == m) break;
            // 答案中添加当前组合
            res.add(Arrays.asList(nums1[cur], nums2[f[cur]]));
            // 当前组合中nums1元素对应的nums2元素下标加一，这样就不会重复用到之前的组合
            f[cur] ++;
        }
        return res;
    }
}
