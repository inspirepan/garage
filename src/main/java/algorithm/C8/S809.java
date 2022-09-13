package algorithm.C8;

public class S809 {
    class Solution {
        // 没有什么优化，之后可以考虑使用字典树来优化
        public int expressiveWords(String s, String[] words) {
            int count = 0;
            for (String word : words) {
                if (check(s, word)) {
                    count++;
                }
            }
            return count;
        }

        boolean check(String s, String w) {
            int a = 0;
            int b = 0;
            char[] arr1 = s.toCharArray();
            char[] arr2 = w.toCharArray();

            while (b < arr2.length) {
                char c = arr2[b];
                int count1 = 0;
                while (b < arr2.length && arr2[b] == c) {
                    b++;
                    count1++;
                }
                int count2 = 0;
                while (a < arr1.length && arr1[a] == c) {
                    a++;
                    count2++;
                }

                if (count1 > count2) {
                    return false;
                }
                if (count1 < count2 && count2 < 3) {
                    return false;
                }
            }
            return a == arr1.length;
        }
    }
}
