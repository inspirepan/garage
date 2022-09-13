package algorithm.c6;

public class S686 {
    public int repeatedStringMatch(String a, String b) {
        if (b.equals("")) {
            return 0;
        }
        if (a.equals(b)) {
            return 1;
        }
        // abc ca
        if (a.length() >= b.length()) {
            if (a.contains(b)) {
                return 1;
            }
            if (a.repeat(2).contains(b)) {
                return 2;
            }
            return -1;
        }
        // b.len > a.len
        int index = b.indexOf(a);
        if (index == -1) {
            if (a.repeat(2).contains(b)) {
                return 2;
            }
            return -1;
        }
        int len = a.length();
        // [index, index+len-1] 为a
        int count = 1;
        // 头部片段
        if (index > 0) {
            if (index >= len) {
                return -1;
            }
            if (!a.substring(len - index, len).equals(b.substring(0, index))) {
                return -1;
            }
            count++;
        }
        // 中间重复的
        int p = index + len;
        while (p + len < b.length()) {
            if (a.equals(b.substring(p, p + len))) {
                count++;
                p += len;
            } else {
                return -1;
            }
        }
        // 末尾片段
        if (p < b.length()) {
            if (a.indexOf(b.substring(p)) == 0) {
                count++;
            } else {
                return -1;
            }
        }
        return count;
    }
}
