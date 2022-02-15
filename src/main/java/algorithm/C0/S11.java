package algorithm.C0;

public class S11 {
    /**
     * 直接贪心想不明白，动态规划视角观察一下
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int currCap = Math.min(height[left], height[right])*(right-left);
            max = Math.max(max, currCap);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
