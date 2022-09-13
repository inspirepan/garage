package algorithm.c5;

import java.util.ArrayList;
import java.util.List;

public class S500 {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        for (int i = 0; i < words.length; i++) {
            boolean a1 = false;
            boolean a2 = false;
            boolean a3 = false;
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (a1 && a2 || a1 && a3 || a2 && a3) {
                    break;
                }
                if (s1.contains(String.valueOf(chars[j]))) {
                    a1 = true;
                } else if (s2.contains(String.valueOf(chars[j]))) {
                    a2 = true;
                } else if (s3.contains(String.valueOf(chars[j]))) {
                    a3 = true;
                }
            }
            if (!a1 && !a2 || !a1 && !a3 || !a2 && !a3) {
                list.add(words[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
