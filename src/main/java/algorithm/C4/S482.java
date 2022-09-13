package algorithm.C4;

public class S482 {
    public String licenseKeyFormatting(String s, int k) {
        int clen = 0;
        char[] carray = new char[s.length()];
        for (char c : s.toCharArray()) {
            if (c != '-') {
                carray[clen++] = c;
            }
        }
        String[] ss;
        if (clen % k == 0) {
            ss = new String[clen / k];
        } else {
            ss = new String[clen / k + 1];
        }
        int index = ss.length - 1;
        while (clen >= 1) {
            int i = 0;
            var sb = new StringBuilder();
            while (i < k && clen >= 1) {
                sb.append(Character.toUpperCase(carray[--clen]));
                i++;
            }
            ss[index--] = sb.reverse().toString();
        }
        return String.join("-", ss);
    }
}
