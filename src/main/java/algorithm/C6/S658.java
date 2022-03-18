package algorithm.C6;

import java.util.ArrayList;
import java.util.List;

public class S658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (hi - lo >= k) {
            if (x - arr[lo] > arr[hi] - x) {
                lo++;
            } else {
                hi--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (; lo <= hi; lo++) {
            result.add(arr[lo]);
        }
        return result;
    }
}
