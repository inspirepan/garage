package algorithm.c7;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class S767 {
    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        // 考虑怎么输出""
        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'a']++;
        }

        // 只有一种情况会输出""，就是一个字母的频率超过了一半
        int size = 0;
        for (int n : count) {
            size = Math.max(size, n);
            if (n * 2 > arr.length + 1) {
                return "";
            }
        }
        // 开始填空，用一个二维数组填空
        List<StringBuilder> temp = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            temp.add(new StringBuilder());
        }
        // 要先添加最大的元素
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] > o2[0] ? -1 : 1;
            }
            return o1[1] > o2[1] ? -1 : 1;
        });

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new int[]{i, count[i]});
            }
        }
        int index = 0;
        while (!pq.isEmpty()) {
            int i = pq.poll()[0];
            char c = (char) (i + 'a');
            int k = count[i];
            while (k-- > 0) {
                temp.get(index).append(c);
                index++;
                if (index == size) {
                    index = 0;
                }
            }
        }
        var sb = new StringBuilder();
        temp.forEach(sb::append);
        return sb.toString();
    }
}
