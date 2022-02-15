package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class S1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // 用HashSet提高子集比较的速度
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) {
                    continue;
                }
                var iList = favoriteCompanies.get(i);
                var jList = favoriteCompanies.get(j);
                if (iList.size() >= jList.size()) {
                    continue;
                }
                // iList没有必要变成HashSet，因为containsAll还是遍历，HashSet只是提高了contains的速度
                if (new HashSet<>(jList).containsAll(iList)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                resultList.add(i);
            }
        }
        return resultList;

    }
}
