package algorithm.C7;

public class S789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        // 没想过证明，但是一个方案是鬼和人同时从起点出发，不考虑追逐什么的
        for (int[] ghost : ghosts) {
            if (distance >= Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1])) {
                return false;
            }
        }
        return true;
    }
}
