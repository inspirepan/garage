package algorithm.S201to300;

public class S227 {
    public final int PLUS = 1, MINUS = 2, TIMES = 3, DIVIDE = 4;

    public int calculate(String s) {
        int result = 0;
        int operand = 0;
        int operator = PLUS;
        StringBuilder number = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                switch (operator) {
                    case PLUS -> operand = Integer.parseInt(number.toString());
                    case MINUS -> operand = -Integer.parseInt(number.toString());
                    case TIMES -> operand *= Integer.parseInt(number.toString());
                    case DIVIDE -> operand /= Integer.parseInt(number.toString());
                }
                // 根据当前运算符号选择操作，加减号就把当前的操作数放到结果中去，然后重置操作数
                if (c == '+' || c == '-') {
                    result += operand;
                    operator = (c == '+' ? PLUS : MINUS);
                    operand = 0;
                } else if (c == '*') {
                    operator = TIMES;
                } else {
                    operator = DIVIDE;
                }
                // 遇到运算符就重置StringBuilder
                number = new StringBuilder();
            } else {
                number.append(c);
            }
        }
        // 处理最后一个数
        return result + switch (operator) {
            case PLUS -> Integer.parseInt(number.toString());
            case MINUS -> -Integer.parseInt(number.toString());
            case TIMES -> operand * Integer.parseInt(number.toString());
            case DIVIDE -> operand / Integer.parseInt(number.toString());
            default -> 0;
        };
    }
}
