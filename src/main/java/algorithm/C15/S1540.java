package algorithm.C15;

public class S1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        //小写字符切换最多只要变换25次，之后就是27开始的循环了
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }
            int dist = (int) t.charAt(i) - (int) s.charAt(i);
            if (dist > k) {
                return false;
            }
            if (dist < 0) {
                dist += 26;
            }
            count[dist]++;
            int limit = k / 26 + ((k % 26 >= dist) ? 1 : 0);
            if (count[dist % 26] > limit) {
                return false;
            }
        }
        return true;
    }
}
