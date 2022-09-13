package algorithm.c1;

public class S159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int[] charCount = new int[128];
        int count = 0;
        int max = 0;
        char[] arr = s.toCharArray();
        while (right < arr.length) {
            if (charCount[arr[right]]++ == 0) {
                count++;
            }
            // 保持只有两个元素
            if (count == 3) {
                while (left < right && --charCount[arr[left++]] > 0) {
                    // nothing
                }
                count--;
            }
            max = Math.max(max, ++right - left);
        }
        return max;
    }
}
