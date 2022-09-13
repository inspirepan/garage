package algorithm.C4;

public class S409 {
    private static int getIndex(char c) {
        return c >= 'a' ? (26 + c - 'a') : c - 'A';
    }

    public int longestPalindrome(String s) {
        // 统计字频，然后只能选一个最大的奇数和全部的偶数
        // 原来奇数次的字符也可以用最大的偶数次
        int[] charMap = new int[52];
        for (char c : s.toCharArray()) {
            charMap[getIndex(c)]++;
        }
        int sum = 0;
        boolean hasOdd = false;
        for (int count : charMap) {
            sum += count - (count & 1);
            if ((count & 1) == 1) {
                hasOdd = true;
            }
        }
        return hasOdd ? sum + 1 : sum;
    }
}
