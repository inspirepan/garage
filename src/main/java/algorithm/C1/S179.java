package algorithm.C1;

import java.util.Arrays;

public class S179 {
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
            if (nums[i] > 0) flag = true;
        }
        if (!flag) return "0";
        Arrays.sort(ss, (o1, o2) -> {
            return -(o1 + o2).compareTo(o2 + o1);
        });
        var sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        return sb.toString();
    }
}
