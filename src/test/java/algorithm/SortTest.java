package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void nSortTest() {
        int[] t = new int[]{5, 3, 7, 15, 32, 2, 23, 14, 56, 8, 9};
        Sort.mergeSort(t);
        System.out.println(Arrays.toString(t));
    }
}