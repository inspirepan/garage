package algorithm.c6;

public class S678 {
    public boolean checkValidString(String s) {
        // 记录当前左括号的数量，最小可能值和最大可能值
        int min = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == '*') {
                if (min > 0) {
                    min--; // 用作右括号
                }
                max++; // 用作左括号
            } else if (c == ')') {
                if (min > 0) {
                    min--;
                }
                max--;
            }
            if (max < 0) {
                return false; // 即使全部都用作左括号，左括号数量还是不够
            }
        }
        return min == 0; // 全部用作右括号，还是不够消除左括号
    }
}
