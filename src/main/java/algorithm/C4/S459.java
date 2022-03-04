package algorithm.C4;

public class S459 {
    /* 扩成两倍之后掐头去尾，如果重复肯定包含原字符串 */

    public static boolean repeatedSubstringPattern2(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }
}
