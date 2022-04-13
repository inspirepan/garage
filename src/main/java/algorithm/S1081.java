package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class S1081 {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                    stack.pop();
                }
                stack.push(c);
            }
            count[c - 'a']--;
        }
        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
