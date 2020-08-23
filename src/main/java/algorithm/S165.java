package algorithm;

public class S165 {
    public int compareVersion(String version1, String version2) {
        if (version1.length() == 0 || version2.length() == 0) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for (; i < Math.min(v1.length, v2.length); i++) {
            int s1 = Integer.parseInt(v1[i]);
            int s2 = Integer.parseInt(v2[i]);
            if (s1 > s2) {
                return 1;
            } else if (s1 < s2) {
                return -1;
            }
        }
        if (i == v1.length) {
            while (i < v2.length) {
                if (Integer.parseInt(v2[i++]) > 0) {
                    return -1;
                }
            }
        } else {
            while (i < v1.length) {
                if (Integer.parseInt(v1[i++]) > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
