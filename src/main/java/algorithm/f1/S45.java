package algorithm.f1;

import java.util.Arrays;
import java.util.Comparator;

public class S45 {
    public String minNumber(int[] nums) {
        // 将数字排序就好了，300<301<30<31<3<34  333<33<3
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int p = 0;
                // 找公共部分
                while (p < o1.length() && p < o2.length() && o1.charAt(p) == o2.charAt(p)) {
                    p++;
                }
                if (p == o1.length() && p == o2.length()) {
                    return 0;
                }
                if (p == o1.length()) {
                    // 比较 o1 和 o2 p往后
                    return compare(o1, o2.substring(p));
                } else if (p == o2.length()) {
                    return compare(o1.substring(p), o2);
                } else if (o1.charAt(p) > o2.charAt(p)) {
                    return 1;
                } else if (o1.charAt(p) == o2.length()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        var sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        return sb.toString();
    }
}
