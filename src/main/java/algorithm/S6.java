package algorithm;

import java.util.ArrayList;
import java.util.List;

public class S6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new StringBuilder());
        }
        int currRow = 0;
        boolean direction = true;
        for (char c : s.toCharArray()) {
            result.get(currRow).append(c);
            currRow += direction ? 1 : -1;
            if (currRow == numRows) {
                currRow = numRows - 2;
                direction = false;
            }
            if (currRow == -1) {
                currRow = 1;
                direction = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (var rowSb : result) {
            sb.append(rowSb.toString());
        }
        return sb.toString();
    }
}
