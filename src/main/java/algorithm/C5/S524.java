package algorithm.C5;

import java.util.List;

public class S524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        int len = 0;
        for (var ss : dictionary) {
            if (checkSubSequence(s, ss)) {
                if (ss.length() > len) {
                    result = ss;
                    len = ss.length();
                } else if (ss.length() == len && ss.compareTo(result) < 0) result = ss;
            }
        }
        return result;
    }

    private boolean checkSubSequence(String k, String s) {
        if (k.length() < s.length()) return false;
        int i = 0;
        int j = 0;
        while (j < s.length() && i < k.length()) {
            if (k.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == s.length();
    }
}
