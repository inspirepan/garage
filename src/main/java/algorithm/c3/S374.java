package algorithm.c3;

public class S374 {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid = low + (high - low) / 2;
        int pick = guess(mid);
        while (pick != 0) {
            if (pick == 1) {
                low = mid + 1;
            } else if (pick == -1) {
                high = mid;
            }
            mid = low + (high - low) / 2;
            pick = guess(mid);
        }
        return mid;
    }

    public int guess(int n) {
        return 0;
    }
}
