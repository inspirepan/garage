package algorithm.C1;

public class S125 {
    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        /* 使用正则表达式除掉非字母数字 */
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        String reverse = String.valueOf(new StringBuilder(s).reverse());
        return s.equalsIgnoreCase(reverse);
    }
}