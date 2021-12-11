package algorithm.S101to200;

public class S132 {

    /* 这个解法超出时间限制了 */
    private int currCut = 0;
    private int currMin = Integer.MAX_VALUE;
    private String s;

    public int minCut(String s) {
        this.s = s;
        dfs(0);
        return this.currMin;
    }

    private void dfs(int start) {
        if (start == s.length()) {
            currMin = Math.min(currCut, currMin);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String s1 = s.substring(start, i + 1);
            if (!isPalindrome(s1)) {
                continue;
            }
            this.currCut += 1;
            dfs(i + 1);
            this.currCut -= 1;
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}