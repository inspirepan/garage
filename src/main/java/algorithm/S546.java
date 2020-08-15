package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S546 {


    /* 记忆化回溯，会超时 */
    private final Map<List<Integer>, Integer> map = new HashMap<>();

    public int removeBoxes(int[] boxes) {
        int ans = removeBoxesHelper(boxes);
        System.out.println(map);
        return ans;
    }

    private int removeBoxesHelper(int[] boxes) {
        List<Integer> boxesList = new ArrayList<>();
        for (int box : boxes) {
            boxesList.add(box);
        }
        if (map.containsKey(boxesList)) {
            return map.get(boxesList);
        }
        if (isSingleColor(boxes)) {
            int ans = boxes.length * boxes.length;
            map.put(boxesList, ans);
            return ans;
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int currColor = boxes[0];
        for (; end < boxes.length; end++) {
            if (boxes[end] == currColor) {
                continue;
            }
            int restLen = boxes.length - (end - start);
            int[] restBoxes = new int[restLen];
            System.arraycopy(boxes, 0, restBoxes, 0, start);
            System.arraycopy(boxes, end, restBoxes, start, restLen - start);
            int t = removeBoxesHelper(restBoxes) + (end - start) * (end - start);
            max = Math.max(max, t);
            start = end;
            currColor = boxes[end];
        }
        map.put(boxesList, max);
        return max;
    }

    private boolean isSingleColor(int[] boxes) {
        if (boxes.length == 1) {
            return true;
        }
        boolean result = true;
        final int firstColor = boxes[0];
        for (int i = 1; i < boxes.length; i++) {
            if (boxes[i] != firstColor) {
                result = false;
                break;
            }
        }
        return result;
    }
}