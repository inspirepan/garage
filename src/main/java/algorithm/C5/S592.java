package algorithm.C5;

import java.util.Arrays;

public class S592 {
    public String fractionAddition(String e) {
        // 从字符串提取分数、通分计算、分子分母最大公约数
        int i = 0;
        int[] res = new int[2]; // 分子 分母
        // 符号放在分子里面
        res[1] = 1;
        while (i < e.length()) {
            // 分子和分母的范围是[1,10]
            // 分子可能是负数
            int start = i;
            while (i < e.length() && e.charAt(i) != '/') i++;
            int numerator = Integer.parseInt(e.substring(start, i++));
            start = i++;
            while (i < e.length() && e.charAt(i) != '+' && e.charAt(i) != '-') i++;
            int denominator = Integer.parseInt(e.substring(start, i));
            calculate(res, numerator, denominator);
        }
        // 根据res化简生成字符串
        simplify(res);
        // 这道题用StringBuilder只需要1ms，用字符串相加要5ms，差别好大
        var sb = new StringBuilder();
        sb.append(String.valueOf(res[0])).append("/").append(String.valueOf(res[1]));
        return sb.toString();
    }

    private void calculate(int[] res, int nu2, int de2) {
        int nu1 = res[0], de1 = res[1];
        res[0] = nu1 * de2 + nu2 * de1;
        res[1] = de1 * de2;
    }

    private void simplify(int[] res) {
        if (res[0] == 0) {
            res[1] = 1;
            return;
        }
        int x = Math.abs(res[0]), y = res[1];
        while (true) {
            if (x > y) {
                x -= y;
            } else if (x < y) {
                y -= x;
            } else {
                break;
            }
        }
        res[0] /= x;
        res[1] /= x;
    }
}
