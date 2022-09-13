package algorithm.c3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class S349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i : nums1) {
            list1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        list1.removeIf(integer -> !set2.contains(integer));
        int[] result = new int[list1.size()];
        int i = 0;
        for (int k : list1) {
            result[i++] = k;
        }
        return result;
    }
}
