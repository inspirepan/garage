package algorithm.C1;

public class S125 {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length && !isValidChar(arr[left])) {
            left++;
        }
        while (right >= 0 && !isValidChar(arr[right])) {
            right--;
        }
        while (left < right) {
            if (!isSame(arr[left], arr[right])) {
                return false;
            }
            left++;
            right--;
            while (left < right && !isValidChar(arr[left])) {
                left++;
            }
            while (right > left && !isValidChar(arr[right])) {
                right--;
            }
        }
        return true;
    }

    private boolean isValidChar(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    private boolean isSame(char a, char b) {
        if (a >= '0' && a <= '9') {
            return a == b;
        }
        if (a >= 'a' && a <= 'z') {
            a = (char) (a - ('a' - 'A'));
        }
        if (b >= 'a' && b <= 'z') {
            b = (char) (b - ('a' - 'A'));
        }
        return a == b;
    }
}