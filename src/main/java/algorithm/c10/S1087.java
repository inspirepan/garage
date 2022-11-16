package algorithm.c10;

import java.util.ArrayDeque;
import java.util.Deque;

public class S1087 {
    public String[] expand(String s) {
        // 用一个队列生成就可以了
        Deque<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder());
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == '{') {
                // 按照字典序记录全部的字母
                i++;
                int[] count = new int[26];
                while (i < arr.length && arr[i] != '}') {
                    if (arr[i] != ',') {
                        count[arr[i] - 'a'] = 1;
                    }
                    i++;
                }

                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    var sb = queue.poll();
                    for (int j = 0; j < 26; j++) {
                        if (count[j] > 0) {
                            var nsb = new StringBuilder(sb);
                            nsb.append((char) (j + 'a'));
                            queue.offer(nsb);
                        }
                    }
                }
            } else {
                for (var sb : queue) {
                    sb.append(arr[i]);
                }
            }
            i++;
        }

        String[] res = new String[queue.size()];
        for (int t = 0; t < res.length; t++) {
            res[t] = queue.poll().toString();
        }
        return res;
    }
}
