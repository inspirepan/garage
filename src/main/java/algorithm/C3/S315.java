package algorithm.C3;

import java.util.*;

public class S315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = search(list, nums[i]);
            res.add(index);
            list.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private int search(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
