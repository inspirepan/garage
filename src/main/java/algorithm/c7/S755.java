package algorithm.c7;

public class S755 {
    public int[] pourWater(int[] heights, int volume, int k) {
        // 首先会填满k左边的空隙、直到k左边的高度都大于等于heights[k]
        // 然后填满右边的
        // 想了好久怎么优化模拟，看了下评论，原来用最直白的模拟就可以99%了
        int i = 0;
        while (i < volume) {
            addOne(heights, k);
            i++;
        }
        return heights;
    }

    private void addOne(int[] heights, int k) {
        int p = k - 1;
        while (p >= 0 && heights[p] <= heights[p + 1]) {
            p--;
        }
        if (heights[p + 1] < heights[k]) {
            int t = p + 1;
            while (t + 1 < heights.length && heights[t + 1] == heights[t]) {
                t++;
            }
            heights[t]++;
            return;
        }
        p = k + 1;
        while (p < heights.length && heights[p] <= heights[p - 1]) {
            p++;
        }
        if (heights[p - 1] < heights[k]) {
            int t = p - 1;
            while (t >= 1 && heights[t - 1] == heights[t]) {
                t--;
            }
            heights[t]++;
            return;
        }
        heights[k]++;
    }
}
