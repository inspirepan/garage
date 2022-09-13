package algorithm.C1;

public class S165 {
    public int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\.");
        String[] ss2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < ss1.length && j < ss2.length) {
            int a = Integer.parseInt(ss1[i]);
            int b = Integer.parseInt(ss2[j]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            i++;
            j++;
        }
        while (i < ss1.length) {
            int a = Integer.parseInt(ss1[i]);
            if (a > 0) {
                return 1;
            }
            i++;
        }
        while (j < ss2.length) {
            int b = Integer.parseInt(ss2[j]);
            if (b > 0) {
                return -1;
            }
            j++;
        }
        return 0;
    }
}
