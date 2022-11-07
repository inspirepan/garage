package algorithm.c8;

import java.util.ArrayList;
import java.util.List;

public class S816 {
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            List<String> ans = new ArrayList<>();
            String number = s.substring(1, s.length() - 1);
            for (int i = 1; i < number.length(); i++) {
                for (String n1 : getNumber(number.substring(0, i))) {
                    for (String n2 : getNumber(number.substring(i))) {
                        ans.add(String.format("(%s, %s)", n1, n2));
                    }
                }
            }
            return ans;
        }

        List<String> getNumber(String str) {
            List<String> res = new ArrayList<>();
            if (str.length() == 1) {
                res.add(str);
                return res;
            }
            // 不加小数点
            if (!str.startsWith("0")) {
                res.add(str);
            }
            for (int i = 1; i < str.length(); i++) {
                String left = str.substring(0, i);
                String right = str.substring(i);
                if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
                    res.add(String.format("%s.%s", left, right));
                }
            }
            return res;
        }
    }
}
