package algorithm.c4;

public class S495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }
        int count = 0;
        int last = -duration;
        for (int timeSery : timeSeries) {
            if (timeSery >= last + duration) {
                count += duration;
            } else {
                count += timeSery - last;
            }
            last = timeSery;
        }
        return count;
    }
}
