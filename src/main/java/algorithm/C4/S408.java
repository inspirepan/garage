package algorithm.C4;

public class S408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] wc = word.toCharArray();
        char[] ac = abbr.toCharArray();

        int i = 0;
        int j = 0;
        while (i < wc.length && j < ac.length) {
            if (wc[i] == ac[j]) {
                i++;
                j++;
            } else if (ac[j] >= '0' && ac[j] <= '9') {
                if (ac[j] == '0') return false;
                // 读取数字
                int start = j;
                while (j < ac.length && (ac[j] >= '0' && ac[j] <= '9')) {
                    j++;
                }
                i += Integer.parseInt(abbr.substring(start, j));
            } else {
                return false;
            }
        }
        return i == wc.length && j == ac.length;
    }
}
