package algorithm.C0;

/**
 * KMP
 *
 * @author panjx
 */
public class S28 {
    public int strStr(String haystack, String needle) {

        int n = needle.length(), h = haystack.length();
        for (int i = 0; i < h - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public int strStr2(String haystack, String needle) {

        int neeLen = needle.length();
        int hayLen = haystack.length();
        if (neeLen == 0) {
            return 0;
        }
        if (hayLen == 0 || hayLen < neeLen) {
            return -1;
        }
        int[] nextVal = KMPNextVal(needle);
        int i = 0;
        int j = 0;
        while (i < hayLen && j < neeLen) {
            if (j == -1 || needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else {
                j = nextVal[j];
            }
        }
        if (j == neeLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int[] KMPNextVal(String needle) {
        int[] nextVal = new int[needle.length()];
        nextVal[0] = -1;
        int i = 0;
        int j = -1;
        while (i < needle.length() - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                if (needle.charAt(i) != needle.charAt(j)) {
                    nextVal[i] = j;
                } else {
                    nextVal[i] = nextVal[j];
                }
            } else {
                j = nextVal[j];
            }
        }
        return nextVal;
    }
}
