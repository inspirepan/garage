package algorithm;

public class S38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return String.valueOf(1);
        }
        var last = countAndSay(n - 1);
        var sb = new StringBuilder();
        char prev = last.charAt(0);
        int count = 0;
        for (char c : last.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev);
                prev = c;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}
