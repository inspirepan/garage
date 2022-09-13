package algorithm.c15;

public class S1541 {
    public int minInsertions(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 因为是在任意位置都可以添加，所以这道题其实不怎么在乎顺序，不需要用栈
        // 只需要从两端开始往里面找，一直到中间的子串是平衡的，然后把两边需要的东西补上去就行了
        // 没看清楚条件，需要是两个连续的右括号才行啊
        char[] chars = s.toCharArray();
        int res = 0, len = chars.length, left = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                // 没有左括号了，需要加一个左括号，res++
                if (left == 0) {
                    res++;
                }
                // 匹配掉一个左括号
                else {
                    left--;
                }

                // 以下两种情况只有一个右括号，需要再加一个右括号，res++
                if (i == len - 1 || chars[i + 1] != ')') {
                    res++;
                }
                // 消耗掉连续的一个右括号
                else {
                    i++;
                }
            }
        }
        return res + left * 2; // 剩余的左括号需要2倍的右括号匹配
    }
}
