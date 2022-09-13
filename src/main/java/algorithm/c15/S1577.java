package algorithm.c15;

import java.util.HashMap;
import java.util.Map;

public class S1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        // 两边各运行一次辅助函数
        // Map统计一个数组中的元素值数量，然后计算另一个数组中的所有乘积
        // 又tm是专门恶心Java的测试用例，又要改成Long
        return helper(nums1, nums2) + helper(nums2, nums1);
    }

    private int helper(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        for (int n : a) {
            Long k = (long) n;
            map.put(k * k, map.getOrDefault(k * k, 0) + 1);
        }
        int count = 0;
        // 双重循环遍历全部组合
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = i + 1; j < b.length; j++) {
                long t1 = b[i], t2 = b[j];
                if (map.containsKey(t1 * t2)) {
                    count += map.get(t1 * t2);
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
