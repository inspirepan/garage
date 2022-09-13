package algorithm.c1;

import java.util.LinkedList;
import java.util.Queue;

public class S158 {

    private int read4(char[] buf4) {
        return 0;
    }

    class Solution {

        Queue<Character> last = new LinkedList<>();

        public int read(char[] buf, int n) {

            int i = 0;
            if (last.size() > 0) {
                while (!last.isEmpty() && i < n) {
                    buf[i++] = last.poll();
                }
                if (i == n) {
                    return n;
                }
            }
            int len = 0;
            char[] buf4 = new char[4];
            while (i < n && (len = read4(buf4)) > 0) {
                // 考虑n用完了和原数据用完
                if (n - i < len) {
                    // 有剩余的，放到queue中
                    System.arraycopy(buf4, 0, buf, i, n - i);
                    for (int k = n - i; k < len; k++) {
                        last.offer(buf4[k]);
                    }
                    return n;
                } else {
                    System.arraycopy(buf4, 0, buf, i, len);
                    i += len;
                }
            }
            return i;
        }
    }
}
