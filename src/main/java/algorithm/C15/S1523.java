package algorithm.C15;

public class S1523 {
    public int countOdds(int low, int high) {
        if (low > high) {
            return 0;
        }
        if (low == high) {
            return low & 1;
        }
        if ((low & 1) == 1) {
            return ((high - low) >> 1) + 1;
        } else {
            return (high + 1 - low) >> 1;
        }
    }
}
