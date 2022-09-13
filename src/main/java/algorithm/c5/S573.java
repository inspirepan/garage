package algorithm.c5;

public class S573 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        // 一颗松果距离等于起点-松果-树
        // 其他松果距离等于树-松果-树
        int distance = 0;
        int max = Integer.MIN_VALUE;
        for (var nut : nuts) {
            distance += 2 * distance(nut, tree);
            max = Math.max(max, distance(nut, tree) - distance(nut, squirrel));
        }
        return distance - max;
    }

    private int distance(int[] loc1, int[] loc2) {
        return Math.abs(loc1[0] - loc2[0]) + Math.abs(loc1[1] - loc2[1]);
    }
}
// s   t   n