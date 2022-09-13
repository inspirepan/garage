package algorithm.C15;

import java.util.ArrayList;
import java.util.List;

public class S1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // 只要找到所有没有入口的节点就可以了
        int[] node = new int[n];
        for (var edge : edges) {
            node[edge.get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (node[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
