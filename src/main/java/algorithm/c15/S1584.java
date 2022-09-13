package algorithm.c15;

import java.util.PriorityQueue;

public class S1584 {
    private int[] parent;

    public int minCostConnectPoints(int[][] points) {
        // 真不会
        // 通过PriorityQueue来排序n^2种组合的边长度，选出n-1条不构成回路的边即可
        // 回路通过并查集来判断
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.dis - e2.dis);
        int n = points.length;
        // 每个节点所在的集合根节点
        parent = new int[n];
        int count = 1;
        // 双重循环先把每种组合全部推入队列，这里的ij是在节点的序号不是坐标
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            for (int j = i + 1; j < n; j++) {
                Edge e = new Edge(points, i, j);
                queue.add(e);
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            int dis = e.dis;
            // 如果不是一个集合里面的
            if (!isUnion(x, y)) {
                // 放在一个集合里面，总长度+1
                union(x, y);
                res += dis;
                count++;
            }
            // 凑够了n-1条边，结束
            if (count == n) {
                break;
            }
        }
        return res;
    }

    private int getParent(int i) {
        // 向上递归
        while (i != parent[i]) {
            int temp = parent[i];
            parent[i] = parent[temp];
            i = parent[i];
        }
        return i;
    }

    private boolean isUnion(int i, int j) {
        // 两个节点是不是在同一个集合里面
        int pi = getParent(i);
        int pj = getParent(j);
        return pi == pj;
    }

    private void union(int i, int j) {
        // 设置根节点，将pj加入pi的集合
        int pi = getParent(i);
        int pj = getParent(j);
        if (pi != pj) {
            parent[pj] = pi;
        }
    }

    static class Edge {
        int x;
        int y;
        int dis;

        Edge(int[][] points, int i, int j) {
            x = i;
            y = j;
            dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
        }
    }
}

