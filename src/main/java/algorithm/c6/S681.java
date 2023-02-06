package algorithm.c6;

import java.util.*;

public class S681 {
    public String nextClosestTime(String time) {
         /* 下一个更大的时刻
         最多四个数用来构造
         考虑分钟，如果能组成小于60的更大的，就直接替换
         01：23 -> 01: 30
         如果分钟找不到更大的，就找时钟
         如果时钟能找到小于24的更大的，就替换，把分钟换成最小的
         12：34 -> 13：11
         如果都找不到，全部换成最小的
         23：59 -> 22：22 */

        // 记录可用的数字
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue;
            }
            num.add(time.charAt(i) - '0');
        }
        if (num.size() == 1) {
            // 特殊，只有一种数字
            return time;
        }
        // 因为最多4种数字，最多也就12种组合，因此直接全部求出来
        Integer[] nums = num.toArray(new Integer[num.size()]);
        List<Integer> combinations = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                combinations.add(nums[i] * 10 + nums[j]);
                combinations.add(nums[j] * 10 + nums[i]);
            }
            combinations.add(nums[i] * 10 + nums[i]);
        }
        Collections.sort(combinations);
        int minute = Integer.parseInt(time.substring(3, 5));
        // 找一个比分钟大且小于60的
        boolean mFound = false;
        for (int combination : combinations) {
            if (combination >= 60) {
                break;
            }
            if (combination > minute) {
                mFound = true;
                minute = combination;
                break;
            }
        }
        // 找到了返回，没找到换成最小的
        if (mFound) {
            return time.substring(0, 3).concat(getString(minute));
        } else {
            minute = combinations.get(0);
        }
        // 找时钟
        int hour = Integer.parseInt(time.substring(0, 2));
        boolean hFound = false;
        for (int combination : combinations) {
            if (combination >= 24) {
                break;
            }
            if (combination > hour) {
                hFound = true;
                hour = combination;
                break;
            }
        }
        if (hFound) {
            return getString(hour).concat(":").concat(getString(minute));
        } else {
            String min = getString(combinations.get(0));
            return min.concat(":").concat(min);
        }
    }

    private String getString(int value) {
        // 加上0
        if (value == 0) {
            return "00";
        }
        if (value < 10) {
            return "0".concat(String.valueOf(value));
        }
        return String.valueOf(value);
    }
}
