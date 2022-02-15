package algorithm.C1;

import java.util.Arrays;

public class S179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArray[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strArray, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        var sb = new StringBuilder();
        for (String s : strArray) {
            sb.append(s);
        }
        return "0".equals(strArray[0]) ? "0" : sb.toString();
    }
}
