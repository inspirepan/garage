package algorithm.S201to300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 思路是
 * 1. 拆分字符串，按顺序建立数字和算符两个List，数字总比算符多一个
 * 2. 每次消去一个算符（第i个）要算出第i个数和第i+1个数的运算结果，
 * 3. 全排列算符的消去顺序，多种结果
 * <p>
 * 但是示例结果有重复的，我这个不知道怎么去除“应该要去掉的”重复的——因为同级别的两个括号它认为是一起算的
 * <p>
 * 实际上应该用分治，递归利用左边的结果和右边的结果，这么做是把括号作为“组合”使用，而我的做法是把不同的括号组合带来的“计算顺序”差异
 * 本质上没有区别，所以纠结题解没有实际意义。
 */
public class S241 {
    private final Set<Integer> result = new HashSet<>();
    private final List<Integer> operand = new ArrayList<>();
    private final List<Character> operator = new ArrayList<>();

    public List<Integer> diffWaysToCompute(String input) {
        var numberBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == '-' || c == '+' || c == '*') {
                operator.add(c);
                operand.add(Integer.parseInt(numberBuilder.toString()));
                numberBuilder = new StringBuilder();
            } else {
                numberBuilder.append(c);
            }
        }
        operand.add(Integer.parseInt(numberBuilder.toString()));
//        if (operand.size() == 1) return new ArrayList<>(operand.get(0));
//        if (operand.size() == 0 || operator.size() == 0) return new ArrayList<>();

        dfs();
        return new ArrayList<>(result);
    }

    private void dfs() {
        System.out.print(operand + "  ");
        System.out.println(operator);
        if (operand.size() == 1 && operator.size() == 0) {
            result.add(operand.get(0));
            return;
        }
        for (int i = 0; i < operator.size(); i++) {
            char currOperator = operator.get(i);
            int currOperand1 = operand.get(i);
            int currOperand2 = operand.get(i + 1);
            int answer = switch (currOperator) {
                case '+' -> currOperand1 + currOperand2;
                case '-' -> currOperand1 - currOperand2;
                case '*' -> currOperand1 * currOperand2;
                default -> 0;
            };
            operator.remove(i);
            operand.remove(i);
            operand.remove(i);
            operand.add(i, answer);
            dfs();
            operand.remove(i);
            operand.add(i, currOperand2);
            operand.add(i, currOperand1);
            operator.add(i, currOperator);
        }
    }
}