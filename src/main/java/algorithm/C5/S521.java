package algorithm.C5;

public class S521 {
    public int findLUSlength(String a, String b) {
        // 如果一个字符串的某个子串不是另一个字符串的子串，那么这个字符串本身就不会是另一个字符串的子串
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}
