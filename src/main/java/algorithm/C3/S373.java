package algorithm.C3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class S373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0) {
            return res;
        }
        // 利用一个数组来保存nums1中每个元素对应的最小组合的nums2下标，初始值为0，因为刚开始每个元素对应的最小组合肯定是对面的第一个元素
        int[] index2arr = new int[m];
        // 外层最多遍历k次，获取前k个最小值
        while (res.size() < k) {
            int index1 = 0;
            // 遍历每个nums1元素对应nums2最小可用组合，并获取最小组合
            for (int i = 1; i < m; i++) {
                // 没有可用的index2
                if (index2arr[i] == n) {
                    continue;
                }

                // 最小的组合
                if (index2arr[index1] == n || nums1[index1] + nums2[index2arr[index1]] > nums1[i] + nums2[index2arr[i]]) {
                    // i对应的更小，更新index1
                    index1 = i;
                }
            }
            // 循环全部index1也找不到合适的index2
            if (index2arr[index1] == n) {
                break;
            }
            // 答案中添加当前组合
            res.add(Arrays.asList(nums1[index1], nums2[index2arr[index1]]));
            index2arr[index1]++;
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        int m = Math.min(nums1.length, k), n = nums2.length;
        // 最多k个
        for (int i = 0; i < m; ++i) {
            pq.offer(new int[] {i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] index = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[index[0]]);
            list.add(nums2[index[1]]);
            ans.add(list);
            // 将下一个可能的元素加入
            if (++index[1] < n) {
                pq.offer(index);
            }
        }
        return ans;
    }
}
