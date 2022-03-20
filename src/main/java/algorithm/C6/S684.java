package algorithm.C6;

public class S684 {
    private int[] pre;

    public int[] findRedundantConnection(int[][] edges) {
        // 抄的
        int m = edges.length, rx, ry;
        if (m == 0) return null;
        pre = new int[m + 1];
        for (int[] e : edges) {
            int n1 = e[0], n2 = e[1];
            // 两个都是新结点
            if (pre[n1] == 0 && pre[n2] == 0) pre[n1] = pre[n2] = n1;
                // 其中一个是新结点
            else if (pre[n1] == 0) pre[n1] = findRoot(n2);
            else if (pre[n2] == 0) pre[n2] = findRoot(n1);
                // 两个结点的根节点是一样的，即找到环了
            else if ((rx = findRoot(n1)) == (ry = findRoot(n2))) return e;
                // 把根节点连接起来
            else pre[rx] = ry;
        }
        return null;
    }

    private int findRoot(int node) {
        int root = node;
        // 找到 x 的根节点
        while (pre[root] != root) root = pre[root];
        int curr = node, prev;
        // 在把路径上的所有结点根节点都设为root
        while (curr != root) {
            prev = pre[curr];
            pre[curr] = root;
            curr = prev;
        }
        return root;
    }
}
