package algorithm.c15;

public class S1578 {
    public int minCost(String colors, int[] neededTime) {
        // 连续相同的n个字符选n-1个移除
        // 遍历一遍 记录重复的颜色的时间总和以及最大值
        char[] chars = colors.toCharArray();
        int i = 1;
        int prev = chars[0];
        int totalCount = 0;
        int currCount = neededTime[0];
        int currMax = neededTime[0];
        while (i < chars.length) {
            if (chars[i] != prev) {
                totalCount += currCount - currMax;
                currCount = neededTime[i];
                currMax = neededTime[i];
            } else {
                currCount += neededTime[i];
                currMax = Math.max(currMax, neededTime[i]);
            }
            prev = chars[i];
            i++;
        }
        totalCount += currCount - currMax;
        return totalCount;
    }
}
