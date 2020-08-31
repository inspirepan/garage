package algorithm;

/**
 * 1286
 */
public class CombinationIterator {

    private int[] combination;
    private final char[] charArr;

    public CombinationIterator(String characters, int combinationLength) {
        combination = new int[combinationLength];
        charArr = characters.toCharArray();
        for (int i = 0; i < combinationLength; i++) {
            combination[i] = i;
        }
        combination[combinationLength - 1]--;
    }

    public String next() {
        boolean hasNext = false;
        for (int i = combination.length - 1; i >= 0; i--) {
            if (combination[i] != charArr.length - combination.length + i) {
                int c = ++combination[i];
                while (i + 1 < combination.length) {
                    combination[++i] = ++c;
                }
                hasNext = true;
                break;
            }
        }
        if (hasNext) {
            var sb = new StringBuilder();
            for (int i : combination) {
                sb.append(charArr[i]);
            }
            return sb.toString();
        }
        return null;
    }

    public boolean hasNext() {
        boolean ans = false;
        for (int i = 1; i <= combination.length; i++) {
            if (combination[combination.length - i] != charArr.length - i) {
                ans = true;
                break;
            }
        }
        return ans;
    }
}
