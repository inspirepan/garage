package algorithm.C4;

import java.util.List;

public class S469 {
    public boolean isConvex(List<List<Integer>> points) {
        // 既然保证了可以构成简单多边形，只需要判断角度
        // 顺时针?
        // 要么顺时针要么逆时针
        // 不会做
        int len = points.size();
        if (len < 3) {
            return false;
        }
        if (len == 3) {
            return true;
        }

        for (int i = 1; i < len; i++) {

        }
        return false;
    }

    private boolean cwAngleLess90(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        // 判断p2处形成的角度大小
        // 判断顺时针角度
        return false;
    }

    private boolean acwAngleLess90(List<Integer> p1, List<Integer> p2, List<Integer> p3) {

        return false;
    }
}
