package algorithm.S0to100;

import java.util.LinkedList;

public class S20 {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else if (c == ')' && stack.getFirst() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.getFirst() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.getFirst() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
