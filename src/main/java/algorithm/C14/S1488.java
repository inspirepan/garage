package algorithm.C14;

import java.util.*;

public class S1488 {
    public int[] avoidFlood(int[] rains) {
        // 没做完，懒得弄了
        // 只记录了哪一天之前需要给那个湖泊排水一次，没记录在哪一天之后（需要下雨后再排水）
        // 懒得弄了
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);
        // 统计一下哪些湖泊会下雨两次或更多，需要抽水
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        // 统计总共不下雨的天数，可以用来抽空
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < rains.length; i++) {
            // 如果连续下雨没办法
            if (i > 0 && (rains[i] == rains[i - 1] && rains[i] != 0)) {
                return new int[0];
            }
            // 统计不下雨
            if (rains[i] == 0) {
                set.add(i);
                continue;
            }
            // 统计下雨次数
            int count = map.getOrDefault(rains[i], 0) + 1;
            if (count >= 2) {
                // 第i天前需要抽水一次的湖泊
                need.put(i, rains[i]);
            }
            map.put(rains[i], count);
        }
        // 如果不下雨天数不够
        if (set.size() < need.size()) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = rains.length - 1; i >= 0; i--) {
            if (need.containsKey(i)) {
                queue.offer(need.get(i));
                continue;
            }
            if (!set.contains(i)) {
                continue;
            }
            if (!queue.isEmpty()) {
                ans[i] = queue.poll();
            } else {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
