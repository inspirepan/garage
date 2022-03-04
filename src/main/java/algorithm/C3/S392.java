package algorithm.C3;

public class S392 {
    public boolean isSubsequence(String s, String t) {
        // 还不能改变顺序
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int p = 0;
        int q = 0;
        while (p < cs.length && q < ts.length) {
            if (cs[p] == ts[q]) {
                p++;
            }
            q++;
        }
        return p == cs.length;
    }
}
