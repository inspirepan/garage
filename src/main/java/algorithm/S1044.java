package algorithm;

import java.util.HashSet;
import java.util.Set;

public class S1044 {
    // 字符串哈希+二分搜索
    // 二分很容易
    // 字符串哈希的意思是说，重新定义一个字符串它子串的哈希值计算方法，然后引入两个数组使得计算子串哈希值的时间是O(n)的

    class Solution {
        long[] h, p;

        public String longestDupSubstring(String s) {
            int P = 1313131, n = s.length();
            h = new long[n + 10];
            p = new long[n + 10];
            p[0] = 1;
            for (int i = 0; i < n; i++) {
                p[i + 1] = p[i] * P;
                h[i + 1] = h[i] * P + s.charAt(i);
            }
            String ans = "";
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                String t = check(s, mid);
                if (t.length() != 0) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
                ans = t.length() > ans.length() ? t : ans;
            }
            return ans;
        }

        String check(String s, int len) {
            int n = s.length();
            Set<Long> set = new HashSet<>();
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                long cur = h[j] - h[i - 1] * p[j - i + 1];
                if (set.contains(cur)) {
                    return s.substring(i - 1, j);
                }
                set.add(cur);
            }
            return "";
        }
    }
}
