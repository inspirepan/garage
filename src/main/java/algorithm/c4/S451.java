package algorithm.c4;

import java.util.PriorityQueue;

public class S451 {
    public String frequencySort(String s) {
        // 还是统计词频
        // 然后降序构建字符串
        PriorityQueue<CharNode> pq = new PriorityQueue<CharNode>();
        int[] cmap = new int[128];
        for (char c : s.toCharArray()) {
            cmap[c]++;
        }
        for (int i = 0; i < 128; i++) {
            if (cmap[i] > 0) {
                var cnode = new CharNode((char) i, cmap[i]);
                pq.add(cnode);
            }
        }
        var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var cn = pq.poll();
            sb.append(String.valueOf(cn.c).repeat(cn.freq));
        }
        return sb.toString();
    }

    private class CharNode implements Comparable<CharNode> {
        char c;
        int freq = 0;

        CharNode(char c) {
            this.c = c;
        }

        CharNode(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(CharNode o) {
            if (o.freq == this.freq) {
                return this.c - o.c;
            } else {
                return this.freq > o.freq ? -1 : 1;
            }
        }

        @Override
        public String toString() {
            return c + " " + freq;
        }
    }
}
