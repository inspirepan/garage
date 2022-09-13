package algorithm.c0;

public class S42 {
    class Solution {
        public int trap(int[] height) {
            // 总算弄明白双指针的做法了
            int left = 0;
            int leftMax = height[left];
            int right = height.length - 1;
            int rightMax = height[right];
            int ans = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    leftMax = Math.max(height[left], leftMax);
                    ans += leftMax - height[left];
                    left++;
                } else {
                    rightMax = Math.max(height[right], rightMax);
                    ans += rightMax - height[right];
                    right--;
                }
            }
            return ans;
        }
    }
}
