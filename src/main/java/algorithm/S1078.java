package algorithm;

import java.util.ArrayList;
import java.util.List;

public class S1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] ss = text.trim().split("\\s");
        for (int i = 0; i < ss.length - 2; i++) {
            if (ss[i].equals(first) && ss[i + 1].equals(second)) {
                res.add(ss[i + 2]);
            }
        }
        String[] result = new String[res.size()];
        return res.toArray(result);
    }
}
