package algorithm.c1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S131 {
    private final List<List<String>> result = new ArrayList<>();
    private final LinkedList<String> path = new LinkedList<>();
    private String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return this.result;
    }

    private void dfs(int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String s1 = s.substring(start, i + 1);
            if (!isPalindrome(s1)) {
                continue;
            }
            path.add(s1);
            dfs(i + 1);
            path.removeLast();
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