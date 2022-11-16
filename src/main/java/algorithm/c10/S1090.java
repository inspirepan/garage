package algorithm.c10;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class S1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        // 选出数量小于numWanted，一个标签最多useLimit
        // values和最高

        // 还是按照values排序，然后从高往低选，

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < values.length; i++) {
            pq.offer(new Node(values[i], labels[i]));
        }
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        int k = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int c = count.getOrDefault(curr.label, 0) + 1;
            if (c <= useLimit) {
                res += curr.value;
                count.put(curr.label, c);
                if (++k == numWanted) {
                    break;
                }
            }
        }
        return res;
    }

    class Node implements Comparable<Node> {
        int value;
        int label;

        Node(int v, int l) {
            value = v;
            label = l;
        }

        public int compareTo(Node o) {
            return o.value - this.value;
        }
    }
}
