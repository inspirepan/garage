package algorithm.C0;

public class S76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] tCount = new int[128];
        for (char c : t.toCharArray()) tCount[c]++;
        int k = t.length();
        char[] sArr = s.toCharArray();
        int[] sCount = new int[128];
        for (int i = 0; i < k; i++) {
            sCount[sArr[i]]++;
        }
        if (compare(sCount, tCount) == 0) return s.substring(0, k);

        int right = k;
        int left = 0;
        String res = "";
        while (right <= s.length()) {
            if (compare(sCount, tCount) < 0) {
                if (right == s.length()) {
                    // 没法再往右扩了
                    break;
                }
                sCount[sArr[right]]++;
                right++;
            } else {
                if (res.equals("") || right - left < res.length()) {
                    res = s.substring(left, right);
                    if (right - left == k) return res;
                }
                // 尝试左缩
                sCount[sArr[left++]]--;
            }
        }
        return res;
    }

    private int compare(int[] s, int[] t) {
        // 对于t中全部字符
        boolean isSame = true;
        for (int i = 0; i < 128; i++) {
            if (s[i] < t[i]) return -1;
            if (s[i] > t[i]) isSame = false;
        }
        return isSame ? 0 : 1;
    }
}
