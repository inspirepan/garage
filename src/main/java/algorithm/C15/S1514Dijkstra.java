package algorithm.C15;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class S1514Dijkstra {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<List<Pair>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new Pair(succProb[i], e[1]));
            graph.get(e[1]).add(new Pair(succProb[i], e[0]));
        }

        // 默认是小顶堆，小的在上面，因此要重写compareTo
        PriorityQueue<Pair> que = new PriorityQueue<Pair>();
        double[] prob = new double[n];

        que.offer(new Pair(1, start));
        prob[start] = 1;
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            double pr = pair.probability;
            int node = pair.node;
            if (pr < prob[node]) {
                continue;
            }
            for (Pair pairNext : graph.get(node)) {
                double prNext = pairNext.probability;
                int nodeNext = pairNext.node;
                // 如果新的路径的概率比记录的大
                // 就往下探
                if (prob[nodeNext] < prob[node] * prNext) {
                    prob[nodeNext] = prob[node] * prNext;
                    que.offer(new Pair(prob[nodeNext], nodeNext));
                }
            }
        }
        return prob[end];
    }

    class Pair implements Comparable<Pair> {
        double probability;
        int node;

        public Pair(double probability, int node) {
            this.probability = probability;
            this.node = node;
        }

        public int compareTo(Pair pair2) {
            if (this.probability == pair2.probability) {
                return this.node - pair2.node;
            } else {
                // 为了实现大顶堆，改成这种比较方式
                return this.probability - pair2.probability > 0 ? -1 : 1;
            }
        }
    }
}
