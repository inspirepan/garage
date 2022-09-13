package algorithm.c14;

import java.util.ArrayList;
import java.util.List;

public class S1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (j <= n && i < target.length) {
            if (target[i] == j) {
                result.add("Push");
                j++;
                i++;
            } else {
                result.add("Push");
                result.add("Pop");
                j++;
            }
        }
        return result;
    }
}
