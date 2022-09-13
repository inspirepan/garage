package algorithm.C2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S267 {
    int[] cnt;
    List<String> res = new ArrayList<>();
    LinkedList<Character> path = new LinkedList<>();
    int len;

    public List<String> generatePalindromes(String s) {
        cnt = new int[128];
        len = s.length();
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        boolean flag = false;
        int single = 0;
        for (int i = 0; i < 128; i++) {
            if ((cnt[i] & 1) == 1) {
                if (flag) {
                    return res;
                }
                flag = true;
                single = i;
            }
        }
        if (flag) {
            path.add((char) single);
            cnt[single]--;
        }
        build();
        return res;
    }

    void build() {
        if (path.size() == len) {
            var sb = new StringBuilder();
            for (char c : path) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        // 挑选一对加入
        for (int i = 0; i < 128; i++) {
            if (cnt[i] > 0) {
                cnt[i] -= 2;
                path.addFirst((char) i);
                path.addLast((char) i);
                build();
                path.removeLast();
                path.removeFirst();
                cnt[i] += 2;
            }
        }
    }
}
