package algorithm.c2;

import java.util.ArrayDeque;
import java.util.Deque;

public class S224 {
    class Solution {
        public int calculate(String s) {
            char[] arr = s.toCharArray();
            Deque<Integer> nums = new ArrayDeque<>();
            Deque<Character> op = new ArrayDeque<>();
            int i = 0;
            nums.push(0);

            while (i < arr.length) {
                char c = arr[i];
                if (c != ' ') {
                    if (Character.isDigit(c)) {
                        int num = c - '0';
                        while (i < arr.length - 1 && Character.isDigit(arr[i + 1])) {
                            num *= 10;
                            num += arr[++i] - '0';
                        }
                        // 遇到一个数字，如果能计算（非算式或者括号内第一个数），那么就立即计算
                        if (!op.isEmpty() && op.peek() != '(') {
                            int n2 = nums.pop();
                            char o = op.pop();
                            nums.push(o == '+' ? n2 + num : n2 - num);
                        } else {
                            nums.push(num);
                        }
                    } else if (c == '+') {
                        // 运算符直接入栈
                        op.push(c);
                    } else if (c == '-') {
                        op.push(c);
                        // 因为有负数的形式，所以对于第一个数，补一个0
                        if (i > 0 && (arr[i - 1] == '(')) {
                            nums.push(0);
                        }
                    } else if (c == '(') {
                        op.push(c);
                    } else {
                        // 弹出一对括号，如果括号外面有计算，在这里算出来
                        op.pop();
                        if (!op.isEmpty() && (op.peek() == '+' || op.peek() == '-')) {
                            int n1 = nums.pop();
                            int n2 = nums.pop();
                            int o = op.pop();
                            nums.push(o == '+' ? n1 + n2 : n2 - n1);
                        }
                    }
                }
                i++;
            }

            return nums.pop();
        }
    }
}
