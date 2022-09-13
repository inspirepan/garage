package algorithm.c2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class S218 {
    // 复制题解
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 根据高度排序
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        List<Integer> boundaries = new ArrayList<Integer>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = buildings.length, idx = 0;
        for (int boundary : boundaries) {
            // 如果当前建筑左边界小于boundary
            // pq放入右边界和高度
            while (idx < n && buildings[idx][0] <= boundary) {
                pq.offer(new int[] {buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            // 将右边界小于当前boundary的建筑出列
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }
            // 当前的高度是0或者pq队首的高度
            int maxn = pq.isEmpty() ? 0 : pq.peek()[1];
            // 如果是最左边  或者上一个天际线高度与当前高度不一样，发生了变化
            if (ret.size() == 0 || maxn != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(boundary, maxn));
            }
        }
        return ret;
    }

    class Solution {
        public List<List<Integer>> getSkyline(int[][] bs) {
            List<List<Integer>> ans = new ArrayList<>();
            List<int[]> ps = new ArrayList<>();
            for (int[] b : bs) {
                int l = b[0], r = b[1], h = b[2];
                ps.add(new int[] {l, h, -1});
                ps.add(new int[] {r, h, 1});
            }
            /**
             * 先严格按照横坐标进行「从小到大」排序
             * 对于某个横坐标而言，可能会同时出现多个点，应当按照如下规则进行处理：
             * 1. 优先处理左端点，再处理右端点
             * 2. 如果同样都是左端点，则按照高度「从大到小」进行处理（将高度增加到优先队列中）
             * 3. 如果同样都是右端点，则按照高度「从小到大」进行处理（将高度从优先队列中删掉）
             */
            Collections.sort(ps, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                if (a[2] != b[2]) {
                    return a[2] - b[2];
                }
                if (a[2] == -1) {
                    return b[1] - a[1];
                } else {
                    return a[1] - b[1];
                }
            });
            // 记录进行了删除操作的高度，以及删除次数
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
            int prev = 0;
            q.add(prev);
            for (int[] p : ps) {
                int point = p[0], height = p[1], flag = p[2];
                if (flag == -1) {
                    q.add(height);
                } else {
                    map.put(height, map.getOrDefault(height, 0) + 1);
                }

                while (!q.isEmpty()) {
                    int peek = q.peek();
                    if (map.containsKey(peek)) {
                        if (map.get(peek) == 1) {
                            map.remove(peek);
                        } else {
                            map.put(peek, map.get(peek) - 1);
                        }
                        q.poll();
                    } else {
                        break;
                    }
                }

                int cur = q.peek();
                if (cur != prev) {
                    List<Integer> list = new ArrayList<>();
                    list.add(point);
                    list.add(cur);
                    ans.add(list);
                    prev = cur;
                }
            }
            return ans;
        }
    }

}
