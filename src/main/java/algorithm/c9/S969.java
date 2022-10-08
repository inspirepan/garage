package algorithm.c9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : panjixiang
 * @since : 2022/9/27
 */
public class S969 {
    // 不会做 完全模拟的思路
    class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            int len = arr.length;
            for (int i = len; i > 0; i--) {
                // look for the position of i
                int pos = lookForPosition(arr, i);
                // if current number is on its position, continue
                if (i == pos + 1) continue;
                ans.add(pos + 1);
                ans.add(i);
                reverse(arr, pos);
                reverse(arr, i - 1);
            }
            return ans;
        }

        // look for position for a num
        public int lookForPosition(int[] arr, int num) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) return i;
            }
            return 0;
        }

        // reverse array from the beginning to the end
        public void reverse(int[] arr, int end) {
            int left = 0;
            int right = end;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
