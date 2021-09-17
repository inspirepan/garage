package algorithm;

import java.util.ArrayList;
import java.util.List;

public class S6 {
    /*
    这道题的关键是行的数据是不重要的，只需要遍历一遍字符串，确定每一个字符所在的行就行了
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new StringBuilder());
        }
        // 每一行都设置一个StringBuilder
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
