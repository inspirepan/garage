package algorithm.c3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S315bin {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            // 从右往左
            // list是当前i右边的数，nums[i]是当前的数，list中是有序的，所以只需要用二分搜索的方法插入就可以了，找到index
            int index = search(list, nums[i]);
            res.add(index);
            list.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private int search(List<Integer> list, int target) {
        // 二分找到list中小于target的数量
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
