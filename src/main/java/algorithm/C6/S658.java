package algorithm.C6;

import java.util.ArrayList;
import java.util.List;

public class S658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            if (x - arr[left] > arr[right] - x) left++;
            else right--;
        }
        // left+k-1=right
        List<Integer> result = new ArrayList<>();
        while (left <= right) result.add(arr[left++]);
        return result;
    }
}
