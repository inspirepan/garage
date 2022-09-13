package algorithm.C7;

public class S744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < letters[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l == len) {
            return letters[0];
        } else {
            return letters[l];
        }
    }
}
