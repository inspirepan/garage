package algorithm.C0;

import java.util.*;

public class S2055 {
    public int[] platesBetweenCandles2(String s, int[][] queries) {
        // 用两个数组记录每个坐标左右最近的蜡烛位置
        int len = s.length();
        int[] left = new int[len];
        int[] right = new int[len];
        // 一个数组记录每个蜡烛的index
        int prevCancle = -1;
        int index = 0;
        int[] candleIndex = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '|') {
                prevCancle = i;
                left[i] = i;
                candleIndex[i] = index++;
            } else {
                left[i] = prevCancle;
                candleIndex[i] = -1;
            }
        }
        prevCancle = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                prevCancle = i;
                right[i] = i;
            } else {
                right[i] = prevCancle;
            }
        }
        int[] result = new int[queries.length];
        // 如果蜡烛数量小于等于两个
        if (index <= 2) return result;
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int lc = right[l];
            int rc = left[r];
            if (lc == -1 || rc == -1 || lc >= rc) result[i] = 0;
            else result[i] = rc - lc - (candleIndex[rc] - candleIndex[lc]);
        }
        return result;
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 用一个TreeMap记录蜡烛的位置，一开始的写法
        // TreeMap太慢了，我们本来就是index，是有序的，这种情况下为了使用floor和ceiling直接用数组记录就可以了，只有那种本来是乱序的再用TreeMap！
        int len = s.length();
        char[] c = s.toCharArray();
        // 用一个结构来记录全部的蜡烛的坐标，以及它是第几个蜡烛（0开始）
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int candleIndex = 0;
        for (int i = 0; i < len; i++) if (c[i] == '|') treeMap.put(i, candleIndex++);
        int[] result = new int[queries.length];
        if (treeMap.size() < 2) return result;
        for (int i = 0; i < result.length; i++) {
            int[] query = queries[i];
            int left = query[0], right = query[1];
            // 如果没有更大或者更小的蜡烛
            if (null == treeMap.ceilingKey(left) || null == treeMap.floorKey(right)) {
                result[i] = 0;
                continue;
            }
            int fLeft = treeMap.ceilingKey(left);
            int fRight = treeMap.floorKey(right);
            if (fLeft >= fRight) {
                result[i] = 0;
                continue;
            }
            int candleLeft = treeMap.get(fLeft);
            int candleRight = treeMap.get(fRight);
            result[i] = fRight - fLeft - 1 - (candleRight - candleLeft - 1);
        }
        return result;
    }
}
