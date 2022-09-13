package algorithm.c14;

import java.util.LinkedList;

public class S1493 {

    public int longestSubarray2(int[] nums) {
        // 看了评论的统计思路之后写的
        // 就是统计连续的两个块
        // 注意全是1的情况
        int leftCount = 0;
        int rightCount = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                rightCount++;
            } else if (nums[i] == 0) {
                leftCount = rightCount;
                rightCount = 0;
            }
            max = Math.max(max, rightCount + leftCount);
        }
        return max == nums.length ? nums.length - 1 : max;
    }

    public int longestSubarray(int[] nums) {
        // 显然还是从全局考虑比较好，不用动态规划了
        // 那么，首先考虑没有0的情况，那么长度就length-1
        // 然后把0的位置都找出来，如果只有一个，那长度也是length-1
        // 大于一个零，那么从所有的0中选一个，看哪一个的结果最长
        // 做出来了，不过好慢
        if (nums.length <= 1) {
            return 0;
        }
        LinkedList<Integer> zindex = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zindex.add(i);
            }
        }
        if (zindex.size() <= 1) {
            return nums.length - 1;
        }
        if (zindex.size() == nums.length) {
            return 0;
        }
        // 开始考虑普通情况

        int max = 0;
        // 加上边界
        zindex.addFirst(-1);
        zindex.add(nums.length);
        System.out.println(zindex);
        for (int i = 1; i < zindex.size() - 1; i++) {
            max = Math.max(max, -zindex.get(i - 1) + zindex.get(i + 1) - 2);
        }
        return max;
    }
}
