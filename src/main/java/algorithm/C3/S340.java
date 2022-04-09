package algorithm.C3;

public class S340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        if (s.length() == 0) return 0;
        int[] count = new int[256];
        int types = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        int right = 0;
        int left = 0;
        int max = 0;

        while (right < len) {
            // 先把right所在的字符加入窗口
            // 其实可以一直right++的，这样可以省略一些个max比较判断的时间，不过不是很关键吧
            if (++count[arr[right]] == 1) {
                types++;
            }
            if (types > k) {
                // 左缩窗口，直到types<k
                while (left < right) {
                    if (--count[arr[left++]] == 0) {
                        types--;
                    }
                    if (types == k) {
                        break;
                    }
                }
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }
}
