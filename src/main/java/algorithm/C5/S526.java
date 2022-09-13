package algorithm.C5;

public class S526 {
    int count = 0;
    int n;

    public int countArrangement(int n) {
        // 动态规划
        // dp i 表示n可以构成的数量，dp i = dpi-1 +1 + 可以互换位置的数量， i可以和它的因数互换位置，不对啊不一定可以换位置
        // 看了下测试的范围比较小，只到15，所以直接无剪枝的dfs也是可以的
        this.n = n;
        boolean[] visited = new boolean[n + 1];
        dfs(0, visited);
        return count;
    }

    private void dfs(int index, boolean[] visited) {
        // index + 1 对应 i
        if (index == n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if ((i == index + 1) || (i > index + 1 && i % (index + 1) == 0) || (i < index + 1 && (index + 1) % i == 0)) {
                visited[i] = true;
                dfs(index + 1, visited);
                visited[i] = false;
            }
        }
    }
}
