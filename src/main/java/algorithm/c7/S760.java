package algorithm.c7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class S760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                map.get(nums2[i]).add(i);
            } else {
                var list = new LinkedList<Integer>();
                list.add(i);
                map.put(nums2[i], list);
            }
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            LinkedList<Integer> list = map.get(nums1[i]);
            res[i] = list.get(0);
            list.removeFirst();
        }
        return res;
    }
}
