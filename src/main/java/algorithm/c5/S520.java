package algorithm.c5;

public class S520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        int i;
        if (isCapital(word.charAt(0))) {
            // 后面的要么全部小写要么全部大写
            i = 2;
            if (isCapital(word.charAt(1))) {
                while (i < word.length()) {
                    if (!isCapital(word.charAt(i++))) {
                        return false;
                    }
                }
            } else {
                while (i < word.length()) {
                    if (isCapital(word.charAt(i++))) {
                        return false;
                    }
                }
            }
        } else {
            // 全部小写
            i = 1;
            while (i < word.length()) {
                if (isCapital(word.charAt(i++))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
