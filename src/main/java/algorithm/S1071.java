package algorithm;

public class S1071 {
    public String gcdOfStrings(String str1, String str2) {
        // 公因子
        if (str1.length() == str2.length()) {
            if (str1.equals(str2)) return str1;
            return "";
        }
        // 找本身的公因子
        int i = 0;
        int min = Math.min(str1.length(), str2.length());
        String res = "";
        while (i < min && str1.charAt(i) == str2.charAt(i)) {
            if (str1.length() % (i + 1) == 0 && str2.length() % (i + 1) == 0) {
                String sub = str1.substring(0, i + 1);
                if (str1.equals(sub.repeat(str1.length() / (i + 1))) && str2.equals(sub.repeat(str2.length() / (i + 1)))) {
                    res = sub;
                }
            }

            i++;
        }
        return res;
    }
}
