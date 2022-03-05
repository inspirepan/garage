package algorithm.C4;

import java.util.HashMap;
import java.util.Map;

public class S423 {
    public String originalDigits(String s) {
        //因为题目保证可以分解，因此统计完字母频率之后，只需要根据特定字母来计算各个数字的数量就可以了，推导关系如下
        // 一开始想用dfs找全部情况的，所以统计了所有数字的全部字母频率，其实没有必要，但是懒得改了
        // z=0
        // w=2
        // x=6
        // g=8
        // t-2-8=3
        // r-0-3=4
        // o-0-2-4=1
        // f-4=5
        // s-6=7
        // 9

        int[] charMap = new int[26];
        for (char c : s.toCharArray()) charMap[c - 'a']++;
        // 各种数字的字母频率
        Map<Integer, int[]> numberCharMap = new HashMap<>();
        numberCharMap.put(0, getCharMap("zero"));
        numberCharMap.put(1, getCharMap("one"));
        numberCharMap.put(2, getCharMap("two"));
        numberCharMap.put(3, getCharMap("three"));
        numberCharMap.put(4, getCharMap("four"));
        numberCharMap.put(5, getCharMap("five"));
        numberCharMap.put(6, getCharMap("six"));
        numberCharMap.put(7, getCharMap("seven"));
        numberCharMap.put(8, getCharMap("eight"));
        numberCharMap.put(9, getCharMap("nine"));

        // 题目保证存在符合要求的字符串
        // 统计结果中各个数字的数量
        int[] result = new int[10];
        // z 0
        if (charMap['z' - 'a'] > 0) {
            result[0] = charMap['z' - 'a'];
            for (int i = 0; i < result[0]; i++) arrSub(charMap, numberCharMap.get(0));
        }
        // w 2
        if (charMap['w' - 'a'] > 0) {
            result[2] = charMap['w' - 'a'];
            for (int i = 0; i < result[2]; i++) arrSub(charMap, numberCharMap.get(2));
        }
        // x 6
        if (charMap['x' - 'a'] > 0) {
            result[6] = charMap['x' - 'a'];
            for (int i = 0; i < result[6]; i++) arrSub(charMap, numberCharMap.get(6));
        }
        // g 8
        if (charMap['g' - 'a'] > 0) {
            result[8] = charMap['g' - 'a'];
            for (int i = 0; i < result[8]; i++) arrSub(charMap, numberCharMap.get(8));
        }
        // 3
        if (charMap['t' - 'a'] > 0) {
            result[3] = charMap['t' - 'a'];
            for (int i = 0; i < result[3]; i++) arrSub(charMap, numberCharMap.get(3));
        }
        // 4
        if (charMap['r' - 'a'] > 0) {
            result[4] = charMap['r' - 'a'];
            for (int i = 0; i < result[4]; i++) arrSub(charMap, numberCharMap.get(4));
        }
        // 1
        if (charMap['o' - 'a'] > 0) {
            result[1] = charMap['o' - 'a'];
            for (int i = 0; i < result[1]; i++) arrSub(charMap, numberCharMap.get(1));
        }
        // 5
        if (charMap['f' - 'a'] > 0) {
            result[5] = charMap['f' - 'a'];
            for (int i = 0; i < result[5]; i++) arrSub(charMap, numberCharMap.get(5));
        }
        // 7
        if (charMap['s' - 'a'] > 0) {
            result[7] = charMap['s' - 'a'];
            for (int i = 0; i < result[7]; i++) arrSub(charMap, numberCharMap.get(7));
        }
        // 9
        if (charMap['i' - 'a'] > 0) {
            result[9] = charMap['i' - 'a'];
            for (int i = 0; i < result[9]; i++) arrSub(charMap, numberCharMap.get(9));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            if (result[i] > 0) sb.append(String.valueOf(i).repeat(result[i]));
        }
        return sb.toString();
    }

    private static int[] getCharMap(String s) {
        int[] charMap = new int[26];
        for (char c : s.toCharArray()) charMap[c - 'a']++;
        return charMap;
    }

    private static void arrSub(int[] a, int[] b) {
        assert a.length == b.length;
        for (int i = 0; i < a.length; i++) {
            a[i] -= b[i];
        }
    }
}
