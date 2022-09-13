package algorithm.c5;

public class S565 {
    public int arrayNesting(int[] nums) {
        // 这个倒是挺简单的，就从每一个元素往后套就可以了，记录一下访问过的元素和最长长度
        int[] visited = new int[nums.length];
        int max = 0;
        int visit = 1;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            // 没有访问过的节点
            int k = i;
            int length = 0;
            while (visited[k] != visit) {
                visited[k] = visit;
                k = nums[k];
                length++;
            }
            visit++;
            max = Math.max(max, length);
        }
        return max;
    }
}
