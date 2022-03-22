package algorithm.C7;

/**
 * 太久没写题又忘记了，对于char类型的计数不要用Map、Set，用数组
 */
public class S771 {
    public int numJewelsInStones(String J, String S) {
        int[] record = new int[58];
        if (J.length() == 0 || S.length() == 0) return 0;
        for (char j : J.toCharArray()) record[j - 'A'] = 1;
        int count = 0;
        for (char s : S.toCharArray()) if (record[s - 'A'] == 1) count++;
        return count;
    }
}
