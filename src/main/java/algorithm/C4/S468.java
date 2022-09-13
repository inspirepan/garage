package algorithm.C4;

public class S468 {
    public String validIPAddress(String queryIP) {
        String neither = "Neither";
        if (queryIP.indexOf('.') != -1) {
            // v4
            if (queryIP.charAt(queryIP.length() - 1) == '.') {
                return neither;
            }
            String[] ss = queryIP.split("\\.");
            // 注意的是，如果最后一个字符是. 那么长度也是4，split是将每个匹配的后面一串加入数组的
            if (ss.length != 4) {
                return neither;
            }
            for (String i : ss) {
                if (i.length() == 0 || i.length() > 3) {
                    return neither;
                }
                if (i.length() > 1 && i.charAt(0) == '0') {
                    return neither;
                }
                for (char c : i.toCharArray()) {
                    if (c < '0' || c > '9') {
                        return neither;
                    }
                }
                int v = Integer.parseInt(i);
                if (v < 0 || v > 255) {
                    return neither;
                }
            }
            return "IPv4";
        } else if (queryIP.indexOf(':') != -1) {
            // v6
            if (queryIP.charAt(queryIP.length() - 1) == ':') {
                return neither;
            }
            String[] ss = queryIP.split(":");
            if (ss.length != 8) {
                return neither;
            }
            for (String i : ss) {
                if (i.length() == 0 || i.length() > 4) {
                    return neither;
                }
                for (char c : i.toCharArray()) {
                    if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                        return neither;
                    }
                }
            }
            return "IPv6";
        } else {
            return neither;
        }
    }
}
