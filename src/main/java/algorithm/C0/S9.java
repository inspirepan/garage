package algorithm.C0;

public class S9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String a = String.valueOf(x);
        char[] c = a.toCharArray();
        int left = 0;
        int right = c.length - 1;
        while (right > left) {
            if (c[left] == c[right]) {
                right--;
                left++;
            } else {
                return false;
            }
        }
        return true;
    }
}
