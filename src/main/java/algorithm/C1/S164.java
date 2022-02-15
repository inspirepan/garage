package algorithm.C1;

public class S164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = 0, min = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int bucketSize = Math.max((max - min) / (nums.length - 1), 1);
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            if (buckets[idx] == null) {
                buckets[idx] = new Bucket();
            }
            buckets[idx].max = Math.max(num, buckets[idx].max);
            buckets[idx].min = Math.min(num, buckets[idx].min);
        }
        int preMax = -1;
        int maxGap = 0;
        for (Bucket bucket : buckets) {
            if (bucket != null && preMax != -1) {
                maxGap = Math.max(maxGap, bucket.min - preMax);
            }
            if (bucket != null) {
                preMax = bucket.max;
            }
        }
        return maxGap;
    }

    static class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
}
