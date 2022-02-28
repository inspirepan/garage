package algorithm.C3;

public class S306 {
    public boolean isAdditiveNumber(String num) {
        // 数不能以0开头，感觉就用dfs做，至少三个数
        // 忘了，前两个数是没有限制的

        // 算法写出来了，有两个例子不能过，long都不够用，服了
        if (num.length() < 3) return false;

        // 如果是0
        if (num.charAt(0) == '0') {
            for (int i = 2; i < num.length(); i++) {
                //选第二个数
                long sec = Long.parseLong(num.substring(1, i));
                if (dfs(i, sec, sec, num)) return true;
            }
        } else {
            // 双重循环前两个数
            for (int i = 1; i < num.length() - 1; i++) {
                // 第一个数[0,i-1]
                long first = Long.parseLong(num.substring(0, i));
                // 选第二个数，考虑0，[i,j-1]
                if (num.charAt(i) == '0') {
                    if (dfs(i + 1, 0, first, num)) return true;
                } else {
                    for (int j = i + 1; j < num.length(); j++) {
                        long second = Long.parseLong(num.substring(i, j));
                        if (dfs(j, second, second + first, num)) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int start, long lastNum, long expectNum, String num) {
        if (start >= num.length()) return false;
        // 如果剩余的数组合起来正好等于期望值，那么返回true

        // 如果以0开头，那么下一个数只能是0
        if (num.charAt(start) == '0') {
            return expectNum == 0 && dfs(start + 1, 0, lastNum, num);
        }
        if (Long.parseLong(num.substring(start)) == expectNum) {
            return true;
        }
        for (int i = start + 1; i < num.length(); i++) {
            // 下一个数[start,i-1]
            long curr = Long.parseLong(num.substring(start, i));
            if (curr == expectNum && dfs(i, curr, lastNum + curr, num)) return true;
        }
        return false;
    }
}
