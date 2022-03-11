package algorithm.C4;

public class S492 {
    public int[] constructRectangle(int area) {
        // 求L*W=area并且尽可能两个数差值小
        int sqr = (int) Math.sqrt(area);
        if (sqr * sqr == area) return new int[]{sqr, sqr};
        while (sqr > 0) {
            if (area % sqr == 0) {
                return new int[]{area / sqr, sqr};
            }
            sqr--;
        }
        return new int[]{area, 1};
    }
}
