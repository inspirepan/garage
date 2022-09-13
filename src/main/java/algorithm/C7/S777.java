package algorithm.C7;

public class S777 {
    public boolean canTransform(String start, String end) {
        // X相当于空位，L可以左移，R可以右移，只能和空位交换位置
        if (start.length() != end.length()) {
            return false;
        }
        int len = start.length();
        char[] sArr = start.toCharArray();
        char[] eArr = end.toCharArray();
        // 去掉空位之后，L和R的相对位置必须一样
        int i = 0;
        int j = 0;
        while (true) {
            while (i < len && sArr[i] == 'X') {
                i++;
            }
            while (j < len && eArr[j] == 'X') {
                j++;
            }
            if (i == len && j == len) {
                return true;
            }
            if (i == len || j == len) {
                return false;
            }
            if (sArr[i] != eArr[j]) {
                return false;
            }
            if (sArr[i] == 'L' && i < j) {
                return false;
            }
            if (sArr[i] == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
    }
}
