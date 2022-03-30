package algorithm;

public class S1246 {

    public class CombinationIterator {
        // CombinationIterator
        private final int[] combination;
        private boolean hasNext = true;
        private final char[] charArr;

        public CombinationIterator(String characters, int combinationLength) {
            combination = new int[combinationLength];
            charArr = characters.toCharArray();
            for (int i = 0; i < combinationLength; i++) {
                combination[i] = i;
            }
        }

        public String next() {
            var sb = new StringBuilder();
            for (int i : combination) {
                sb.append(charArr[i]);
            }
            int i = combination.length - 1;
            for (; i >= 0; i--) {
                if (combination[i] != charArr.length - combination.length + i) {
                    ++combination[i];
                    for (int j = i + 1; j < combination.length; j++) {
                        combination[j] = combination[i] + j - i;
                    }
                    break;
                }
            }
            this.hasNext = i != -1;
            return sb.toString();
        }

        public boolean hasNext() {
            return hasNext;
        }
    }
}
