package algorithm.c5;

import java.util.ArrayList;
import java.util.List;

public class S593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 判断四个点是不是正方形，可以先排序，确定对角线的位置
        List<int[]> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        // 四条边
        int len = distance(list.get(0), list.get(1));
        if (len == 0) {
            return false;
        }
        if (distance(list.get(1), list.get(3)) != len) {
            return false;
        }
        if (distance(list.get(3), list.get(2)) != len) {
            return false;
        }
        if (distance(list.get(2), list.get(0)) != len) {
            return false;
        }
        // 对角线
        return distance(list.get(0), list.get(3)) == 2 * len;
    }

    private int distance(int[] n1, int[] n2) {
        return (n1[0] - n2[0]) * (n1[0] - n2[0]) + (n1[1] - n2[1]) * (n1[1] - n2[1]);
    }
}
