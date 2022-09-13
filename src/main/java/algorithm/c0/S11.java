package algorithm.c0;

public class S11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        // 我从左右两侧开始，那么宽度已经达到最大值了，再往里面缩，就必须要拔高高度，因此就朝着更高的方向缩就行了
        while (left < right) {
            int curr = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, curr);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
