package algorithm.c8;

import java.util.ArrayList;
import java.util.List;

public class S816 {

    // ！！！ 不会写  感觉好麻烦啊
    // 题解的这个写法挺漂亮的，比我无脑回溯写得好看多了

    class Solution {
        public List<String> ambiguousCoordinates(String S) {
            List<String> ans = new ArrayList<>();
            for (int i = 2; i < S.length() - 1; ++i) {
                for (String left : make(S, 1, i)) {
                    for (String right : make(S, i, S.length() - 1)) {
                        ans.add("(" + left + ", " + right + ")");
                    }
                }
            }
            return ans;
        }

        public List<String> make(String S, int i, int j) {
            // Make on S.substring(i, j)
            List<String> ans = new ArrayList<>();
            for (int d = 1; d <= j - i; ++d) {
                String left = S.substring(i, i + d);
                String right = S.substring(i + d, j);
                if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0")) {
                    ans.add(left + (d < j - i ? "." : "") + right);
                }
            }
            return ans;
        }
    }
}
