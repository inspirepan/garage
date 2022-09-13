package algorithm.c14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S1443 {
    // 记录每个节点为起点的边
    // 结果的路径长度是两倍的关系
    Map<Integer, List<int[]>> map = new HashMap<>();

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for (int[] edge : edges) {
            List<int[]> list = new ArrayList<>();
            // 记录起点
            if (map.containsKey(edge[0])) {
                list = map.get(edge[0]);
                list.add(edge);
            } else {
                list.add(edge);
            }
            map.put(edge[0], list);
        }
        return 2 * traverse(hasApple, 0);
    }

    //计算获取一棵子树里的所有苹果所需要的最短路径长度，如果子树只有一个节点返回0；
    //对于根节点n的每个子节点i，加上递归求解子树i的结果

    public int traverse(List<Boolean> hasApple, int i) {
        //如果越界或i是叶子节点没有子节点，返回0；
        if (!map.containsKey(i)) {
            return 0;
        }
        int count = 0;
        //收集以i为根节点的子树最短路径长度
        for (int[] edge : map.get(i)) {
            //遍历i的每一个子节点
            int tmp = traverse(hasApple, edge[1]);
            //对子节点递归求解
            if (tmp > 0) {
                //如果子树上有苹果，加上路径长度+1
                count += tmp + 1;
            } else if (hasApple.get(edge[1])) {
                // 如果子节点有苹果+1
                count += 1;
            }
        }
        return count;
    }
}
