package algorithm.C2;

import java.util.ArrayList;
import java.util.List;

public class S228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        int startVal = nums[0], prevVal = nums[0];
        int index = 1;
        int currVal;
        while (index < len) {
            currVal = nums[index];
            if (currVal > prevVal + 1) {
                // 不连续的时候才提交
                addRange(startVal, prevVal, result);
                startVal = currVal;
            }
            index++;
            prevVal = currVal;
        }
        addRange(startVal, nums[len - 1], result);
        return result;
    }

    private void addRange(int start, int end, List<String> list) {
        if (end == start) {
            list.add(String.valueOf(start));
        } else {
            list.add(String.format("%d->%d", start, end));
        }
    }
}
