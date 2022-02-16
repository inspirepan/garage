package algorithm.C14;

import java.util.Arrays;

public class S1433 {
    public boolean checkIfCanBreak(String s1, String s2) {

        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        // 排序
        Arrays.sort(chars);
        Arrays.sort(chars1);

        int i = 0;
        while (i < chars.length) {
            if (chars[i] > chars1[i]) break;

            if (chars[i] <= chars1[i]) {
                i++;
            }
        }

        int j = 0;
        while (j < chars.length) {
            if (chars[j] < chars1[j]) break;

            if (chars[j] >= chars1[j]) {
                j++;
            }
        }

        if (i == chars.length || j == chars.length) return true;
        return false;
    }
}
