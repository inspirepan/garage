package algorithm.c15;

public class S1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        // 同时转向好像就是没转啊，直接冲过去了
        int min = Integer.MAX_VALUE;
        for (int i : right) {
            min = Math.min(i, min);
        }
        int max = 0;
        for (int i : left) {
            max = Math.max(i, max);
        }
        return Math.max(max, (n - min));
    }
}
