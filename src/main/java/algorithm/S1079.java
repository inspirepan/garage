package algorithm;

public class S1079 {
    int ans = 0;

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        dfs(count);
        return ans - 1;
    }

    void dfs(int[] count) {

        ans++;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                count[i]--;
                dfs(count);
                count[i]++;
            }
        }
    }
}
