package algorithm;

import java.util.Arrays;

public class S838 {
    public String pushDominoes(String dominoes) {
        // L...L 最终变成L
        // L...R 立直
        // R...L 收拢
        // R...R 最终变成R
        int len = dominoes.length();
        char[] result = new char[len];
        Arrays.fill(result, '.');
        // 边界情况 *R *L R* L*
        int left = 0;
        int right = len - 1;
        while (left < len && dominoes.charAt(left) == '.')
            left++;
        while (right >= 0 && dominoes.charAt(right) == '.')
            right--;
        // 没有LR
        if (left == len || right == -1)
            return new String(result);
        if (dominoes.charAt(left) == 'L') {
            int k = left;
            while (k >= 0)
                result[k--] = 'L';
        }
        if (dominoes.charAt(right) == 'R') {
            int k = right;
            while (k < len)
                result[k++] = 'R';
        }
        // left到right
        if (left == right)
            return new String(result);
        int i = left;
        while (i <= right) {
            int last = i;
            char prev = dominoes.charAt(i);
            while (dominoes.charAt(++i) == '.') {
            }
            char curr = dominoes.charAt(i);
            if (prev == 'L' && curr == 'L') {
                // LL
                int k = i;
                while (k >= last)
                    result[k--] = 'L';
            } else if (prev == 'R' && curr == 'R') {
                // RR
                int k = i;
                while (k >= last)
                    result[k--] = 'R';
            } else if (prev == 'R' && curr == 'L') {
                // RL
                int l = last;
                int r = i;
                while (l < r) {
                    result[l++] = 'R';
                    result[r--] = 'L';
                }
            }
            // LR不用管
            if (i == right)
                break;
        }
        return new String(result);
    }
}
