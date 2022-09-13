package algorithm;

public class S1100 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] arr = s.toCharArray();
        if (arr.length < k) {
            return 0;
        }
        int[] count = new int[26];
        boolean flag = true;
        for (int i = 0; i < k; i++) {
            if (++count[arr[i] - 'a'] == 2) {
                flag = false;
            }
        }
        int res = 0;
        if (!flag) {
            res++;
        }
        int right = k;
        int left = 0;
        while (right < arr.length) {
            char r = arr[right++];
            char l = arr[left++];

            count[r - 'a']++;
            count[l - 'a']--;
            boolean flag2 = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] > 1) {
                    flag2 = false;
                    break;
                }
            }
            if (flag2) {
                res++;
            }
        }
        return res;
    }
}
