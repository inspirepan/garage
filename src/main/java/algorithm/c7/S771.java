package algorithm.c7;

public class S771 {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] record = new boolean['z' - 'A' + 1];
        if (jewels.length() == 0 || stones.length() == 0) {
            return 0;
        }
        for (char j : jewels.toCharArray()) {
            record[j - 'A'] = true;
        }
        int count = 0;
        for (char s : stones.toCharArray()) {
            if (record[s - 'A']) {
                count++;
            }
        }
        return count;
    }
}
