package algorithm.C5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // 要求索引和最小
        List<String> res = new ArrayList<>();
        // name,index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int indexSum = list1.length + list2.length;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int currSum = i + map.get(list2[i]);
                if (currSum == indexSum) {
                    res.add(list2[i]);
                } else if (currSum < indexSum) {
                    res.clear();
                    res.add(list2[i]);
                    indexSum = currSum;
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
